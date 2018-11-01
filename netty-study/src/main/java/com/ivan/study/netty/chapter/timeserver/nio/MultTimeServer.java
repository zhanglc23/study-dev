package com.ivan.study.netty.chapter.timeserver.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/30.
 */

public class MultTimeServer implements Runnable {

    private Selector selector ;

    private ServerSocketChannel serverSocketChannel ;

    private volatile boolean stop ;

    public MultTimeServer(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.socket().bind(new InetSocketAddress(port) , 1024);
            serverSocketChannel.register(selector , SelectionKey.OP_ACCEPT);
            System.out.println("TIMR SERVER IS STARTED IN PORT " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true ;
    }

    @Override
    public void run() {

        while (!stop) {
            try {
                selector.select(1000L);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();

                    it.remove();

                    try {
                        handleInput(key);
                    }catch (Exception e ) {
                        key.cancel();
                        if(null != key.channel()) {
                            key.channel().close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != selector) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                SocketChannel accept = ssc.accept();
                accept.configureBlocking(false);
                ssc.register(selector , SelectionKey.OP_READ) ;
            }

            if(key.isReadable()) {
                SocketChannel ssc = (SocketChannel)key.channel();

                ByteBuffer bf = ByteBuffer.allocate(1024) ;
                int read = ssc.read(bf);
                if(read > 0) {
                    bf.flip();

                    byte[] bytes = new byte[bf.remaining()];
                    bf.get(bytes) ;

                    String s = new String(bytes, "UTF-8");
                    System.out.println("server is receiver " + s);

                    doWriter(ssc , new Date().toString()) ;
                }else if(read < 0 ){
                    key.cancel();
                    ssc.close();
                }else {
                    System.out.println("server is receiver nothing");
                }
            }
        }

    }

    private void doWriter(SocketChannel ssc, String s) throws IOException {
        if(null != s && s.length() > 0 ) {
            byte[] bytes = s.getBytes();
            ByteBuffer bf = ByteBuffer.allocate(bytes.length);
            bf.put(bytes) ;
            bf.flip();
            ssc.write(bf) ;
        }
    }
}
