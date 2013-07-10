package com.dianping.monkeysocks.socket;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:40 <br>
 */
public class PipeLineSocketTest {

    @Test
    public void testReadAndWriteArray() throws IOException {
        String text = "@author yihua.huang@dianping.com <br>\n" +
                " * @date: 13-7-8 <br>\n" +
                " * Time: 下午8:40 <br>";
        byte[] bytes = text.getBytes();
        bytes[bytes.length - 1] = -1;
        final PipeLineSocket pipeLineSocket = new PipeLineSocket();
        pipeLineSocket.getOutputStream().write(bytes);
        byte[] bytesRead = new byte[bytes.length + 2];
        pipeLineSocket.getInputStream().read(bytesRead);
        String s = new String(bytesRead);
        Assert.assertEquals(text, s);
    }

    @Ignore(value = "infinity")
    @Test
    public void testConcurrentReadAndWrite() throws IOException {
        final PipeLineSocket pipeLineSocket = new PipeLineSocket();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        pipeLineSocket.getOutputStream().write(i & 0xff);
                        Thread.sleep(10);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        pipeLineSocket.getOutputStream().write((byte) 1);
                        Thread.sleep(10);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    int read = 0;
                    try {
                        read = pipeLineSocket.getInputStream().read();
                        System.out.println("t " + read);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        for (int i = 0; i < 1000000; i++) {
            int read = pipeLineSocket.getInputStream().read();
            System.out.println(read);
        }
    }

}
