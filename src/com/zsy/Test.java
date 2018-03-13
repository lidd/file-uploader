package com.zsy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by Lidd on 2018/3/13.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        try(RandomAccessFile raf = new RandomAccessFile("D:/a.txt", "rw")) {

            raf.seek(2);

            byte[] bytes = new byte[]{102,103,104};

            raf.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
