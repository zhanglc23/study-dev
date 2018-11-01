package com.ivan.study.corejava.nio.copyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/28.
 */

public class NioCopyFile {

    public static void main(String[] args) throws IOException {
        String relativelyPath = System.getProperty("user.dir");
        System.out.println(relativelyPath);
        FileInputStream input = new FileInputStream(relativelyPath + "/log.jtl");
        ReadableByteChannel source = input.getChannel();
        FileOutputStream output = new FileOutputStream(relativelyPath + "/aaa.txt");
        WritableByteChannel destination = output.getChannel();
        copyFile(source , destination);
        source.close();
        destination.close();
        System.out.println("end!!!!!!!!!!!!!!");


    }


    public static void copyFile(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buf = ByteBuffer.allocateDirect(20*1024) ;
//        buf.
        while (src.read(buf) != -1) {
            buf.flip() ;
            while (buf.hasRemaining()) {
                dest.write(buf);
            }
            buf.clear();
        }
    }
}
