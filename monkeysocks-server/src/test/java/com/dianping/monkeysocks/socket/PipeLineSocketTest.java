package com.dianping.monkeysocks.socket;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:40 <br>
 */
public class PipeLineSocketTest {

    @Ignore(value = "infinity")
    @Test
    public void test() throws IOException {
        final PipeLineSocket pipeLineSocket = new PipeLineSocket();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        pipeLineSocket.getOutputStream().write((byte) 2);
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
