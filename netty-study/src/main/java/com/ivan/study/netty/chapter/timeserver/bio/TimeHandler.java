package com.ivan.study.netty.chapter.timeserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/30.
 */

public class TimeHandler implements Runnable {

    private Socket socket;

    public TimeHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()) , true);
            String line = null;
            while (true) {
                line = reader.readLine();
                if (null == line)
                    break;

                System.out.println("receivr time req " + line);
                writer.println(new String(new Date().toString()));
            }
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
