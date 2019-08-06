package com.zwq.demo;

import java.io.*;

/*
 * @description:
 * @author: zwq
 * @date: 2018/10/18 17:02
 */
public class TempTest {
    public static void main(String[] args) throws Exception {

        File sourceFile = new File("D:\\proxool.xml");
        InputStream in = new FileInputStream(sourceFile);

        File destFile = new File("D:\\proxool_decode.xml");
        OutputStream fos = new FileOutputStream(destFile, true);

        InputStreamReader isr = new InputStreamReader(in, "utf8");
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            if (line != null && line.contains("password")) {
                //TODO 密文转明文
            }
            byte[] bytes = line.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                fos.write(bytes[i]);
            }
        }

        fos.flush();
        fos.close();
        in.close();

    }

}
