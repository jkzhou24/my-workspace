package com.zwq.demo.mail;

/*
 * @description:
 * @author: zwq
 * @date: 2019/7/15 11:29
 */
import java.io.InputStream;

/**
 * @author jiangyw
 * @date 2019/1/10 21:14
 *
 * 邮件附件类
 */
public class MailAttachment {
    private String name;
    private InputStream inputStream;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public MailAttachment(String name, InputStream inputStream) {
        this.name = name;
        this.inputStream = inputStream;
    }
}