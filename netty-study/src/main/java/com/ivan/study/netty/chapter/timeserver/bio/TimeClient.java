package com.ivan.study.netty.chapter.timeserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/30.
 */

public class TimeClient {

    public static void main(String[] args) {

        Socket socket = null ;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            socket = new Socket("127.0.0.1" , 8080);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()) , true);


            writer.println("hello socket");

            String s = reader.readLine();
            System.out.println("TIME IS " + s);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (null != writer) {
                writer.close();
            }
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }


    }
}
