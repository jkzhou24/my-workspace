package com.zwq.demo.codePattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * @description
 * @author zwq
 * @date 2018/8/20 14:21
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        File file = new File("D:\\ori.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
            if (s.startsWith("InternetAddress")) {
                String internetAddress = s.replace("InternetAddress:  ", "");
                result.append(internetAddress + ",");
            } else if (s.startsWith("LastName")) {
                String lastName = s.replace("LastName:  ", "");
                result.append(lastName + System.lineSeparator());
            }
        }
        br.close();
        System.out.println(System.lineSeparator());
        System.out.println(result.toString());

    }

}
