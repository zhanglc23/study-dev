package com.ivan.study.netty.chapter.timeserver.nio;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/30.
 */

public class NioTimeServer {

    public static void main(String[] args) {
        int port = 8080;

        MultTimeServer server = new MultTimeServer(8080);

        new Thread(server ,"nio-server-01").start();
    }
}
