package com.practice.everyday.io;


import java.io.*;
import java.util.concurrent.locks.ReadWriteLock;

public class TestIO  {
    public static void main(String[] args) {
        testIOStream();
    }
    //读取文件并替换文件中的字符写入新的文件
    public static void testIOStream(){
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            FileInputStream fileInputStream = new FileInputStream("D:\\haier\\zuo.html");
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, len);
            }
            outputStream.toByteArray();
            String value = outputStream.toString("UTF-8");
            String newValue = value.replace("CoolShell", "********");

            Writer writer = new StringWriter(newValue.length());
            writer.write(newValue);
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\haier\\zuo1.html");
            fileOutputStream.write(newValue.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
