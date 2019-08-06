import cn.richinfo.cmail.common.tools.LicenseDES;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import richinfo.tools.Base64Coder;
import richinfo.tools.Tools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
/*
 * Created by JFormDesigner on Sat Dec 29 18:03:08 CST 2018
 */



/**
 * @author zwq
 */
public class LicToolPortable extends JPanel {
    public LicToolPortable() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e){

        if (Tools.isEmpty(textField1.getText())) {
            JOptionPane.showMessageDialog(null, "请先输入license明文", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        if (file == null) {
            return;
        }
        String licDir = file.getAbsolutePath();
        System.out.println(licDir);
        String licName = "key.lic";
        String licJson = textField1.getText();

        StringBuilder licsb = new StringBuilder();
        licsb.append(licJson);
        String licstring = licsb.toString();
        //sn
        System.out.println(Tools.getMD5(licstring));
        licsb.append(";lic_id=").append(Tools.getMD5(licstring));
        licstring = licsb.toString();
        LicCrype_Java_DES_Impl licCrypt = new LicCrype_Java_DES_Impl();
        byte[] licbytes = new byte[0];
        try {
            licbytes = licCrypt.encrypt(licstring.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String base64lic = new String(Base64Coder.encode(licbytes));
        //content
        System.out.println(base64lic);

        File dir = new File(licDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File lic = new File(licDir + "\\" +licName);
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(lic));
            os.write(licbytes);
            os.flush();
            os.close();
            JOptionPane.showMessageDialog(null, "生成key文件成功", "提示", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "转换错误", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.showDialog(new JLabel(), "选择");
        File file = jfc.getSelectedFile();
        if (file == null) {
            return;
        }
        try {
            byte[] eclic = filetoByteArray(file.getAbsolutePath());
            byte[] keybyte = "destkey".getBytes();
            byte[] delic = LicenseDES.DES_Decrypt(keybyte, eclic);
            String keyJson = new String(delic, "UTF-8");

            //去掉licid
            keyJson = keyJson.split(";lic_id=")[0];

            textArea1.setText(keyJson);
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "转换错误", "提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private byte[] filetoByteArray(String filename) throws IOException{

        File f = new File(filename);
        if(!f.exists()){
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int)f.length());
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while(-1 != (len = in.read(buffer,0,buf_size))){
                bos.write(buffer,0,len);
            }
            return bos.toByteArray();
        }catch (IOException e) {
            e.printStackTrace();
            throw e;
        }finally{
            try{
                in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        textArea1 = new JTextArea();

        //======== this ========
        setLayout(new MigLayout(
            "fill,hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[145,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[83]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("license\u660e\u6587\uff1a");
        add(label1, "cell 0 0");
        add(textField1, "cell 1 0 8 1,growx");

        //---- button1 ----
        button1.setText("\u751f\u6210key");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        add(button1, "cell 9 0");

        //---- label2 ----
        label2.setText("license\u6587\u4ef6\uff1a");
        add(label2, "cell 0 2");
        add(textField2, "cell 1 2 8 1,growx");

        //---- button2 ----
        button2.setText("\u6d4f\u89c8");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        add(button2, "cell 9 2");

        //---- textArea1 ----
        textArea1.setEditable(false);
        textArea1.setLineWrap(true);
        add(textArea1, "cell 0 3 9 4,grow");

        //---- bindings ----
        bindingGroup = new BindingGroup();
        bindingGroup.addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
            textArea1, BeanProperty.create("text"),
            textArea1, BeanProperty.create("text")));
        bindingGroup.bind();
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button2;
    private JTextArea textArea1;
    private BindingGroup bindingGroup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        LicToolPortable licPane = new LicToolPortable();
        JFrame jf = new JFrame();
        jf.setTitle("license转换工具(by:ZWQ)");
        jf.setContentPane(licPane);
        jf.setSize(800, 400);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        });
    }
}
