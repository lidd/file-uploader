package com.zsy;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lidd on 2018/3/13.
 */
public class Server {

    public void start(int port) {
        RandomAccessFile raf = null;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             InputStream is = socket.getInputStream();) {


            StringBuilder sb = new StringBuilder();

            byte[] bytes = new byte[1];

            while (is.read(bytes) != -1) {
                sb.append(bytes[0]);
            }

            String message = sb.toString();

            ZsyProtocol protocol = JSON.parseObject(message, ZsyProtocol.class);

            String filename = protocol.getFilename();

            byte[] data = protocol.getData();

            long start = protocol.getStart();

            long len = protocol.getLen();

            raf = new RandomAccessFile(filename, "w");

            raf.seek(start);
            for (int i = 0; i < len; i++) {
                raf.write(data[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void read(){

    }
}
