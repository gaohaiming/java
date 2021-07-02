package com.practice.everyday.io;

import java.io.Closeable;
import java.io.IOException;

public abstract class InputStream implements Closeable {

    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    /**
     * 从输入流读取一个字节
     *
     * @return
     */
    public abstract int read() throws IOException;

    /**
     * 输入流读取的数据到b数组
     *
     * @param b
     * @return
     */
    public int read(byte[] b) throws IOException {
        if (b == null) {
            return 0;
        }
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        if (null == b) {
            throw new NullPointerException();
        } else if (offset < 0 || len < 0 || len > b.length - offset) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return 0;
        }

        int c = read();
        if (c == -1) {
            return -1;
        }
        b[offset] = (byte) c;

        int i = 1;
        for (; i < len; i++) {
            c = read();
            if (c == -1) {
                break;
            }
            b[offset + i] = (byte) c;
        }
        return i;
    }

    public long skip(long n) throws IOException {
        if (n <= 0) {
            return 0;
        }
        long remain = n;
        int size = (int) Math.min(MAX_SKIP_BUFFER_SIZE, remain);
        byte[] skipBuffer = new byte[size];
        while (remain > 0) {
            int nr = read(skipBuffer, 0, (int) Math.min(remain, size));
            if (nr < 0) {
                break;
            }
            remain -= nr;
        }
        return (n - remain);
    }


}
