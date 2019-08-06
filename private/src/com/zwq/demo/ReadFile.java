package com.zwq.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * @description:
 * @author: zwq
 * @date: 2018/12/3 15:11
 */
public class ReadFile {
    public static void main(String[] args) {
        System.out.println();

        String tempStr;
        try {
            FileInputStream fis = new FileInputStream("D:\\jcbank\\HRS_TB_ORG_ORGUNIT_20180810_INIT_00000001.dat");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            tempStr = br.readLine();
            br.close();
            isr.close();
            fis.close();



            System.out.println(tempStr);

            String pattern = ",{1,}";
            tempStr=tempStr.replaceAll("\\p{C}", ",").replaceAll(pattern, ",");
            System.out.println(tempStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
