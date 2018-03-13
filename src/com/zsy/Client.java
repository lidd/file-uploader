package com.zsy;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by Lidd on 2018/3/13.
 */
public class Client {

    public Socket connect(String host, int port) {
        try {
            return new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void send() {
        try (Socket socket = connect("127.0.0.1", 666)) {
            OutputStream os = socket.getOutputStream();

            RandomAccessFile raf = new RandomAccessFile("D:/a.txt", "r");

            ZsyProtocol protocol = new ZsyProtocol();
            protocol.setFilename("a.txt");
            protocol.setLen(5);
            protocol.setMd5("123");

            byte[] container = new byte[5];

            int readBytes = 0;

            for (int i = 0; readBytes != -1; i++) {

                readBytes = raf.read(container);

                protocol.setData(container);

                protocol.setStart(i * 5);

                os.write(protocol.toString().getBytes(Charset.forName("UTF-8")));

            }

            os.flush();
        } catch (IOException e) {
        }

    }
}
