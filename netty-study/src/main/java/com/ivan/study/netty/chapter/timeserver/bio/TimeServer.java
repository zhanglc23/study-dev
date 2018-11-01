package com.ivan.study.netty.chapter.timeserver.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/30.
 */

public class TimeServer {

    public static void main(String[] args) {
        int port = 8080 ;
        try {
            ServerSocket server = new ServerSocket(port);

            while (true) {
                Socket accept = server.accept();
                new Thread(new TimeHandler(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
