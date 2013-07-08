package com.dianping.monkeysocks.socket;

import org.junit.Test;

import java.io.IOException;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:40 <br>
 */
public class PipeLineSocketTest {

    @Test
    public void test() throws IOException {
        PipeLineSocket pipeLineSocket = new PipeLineSocket();
        pipeLineSocket.getOutputStream().write(1);
        int read = pipeLineSocket.getInputStream().read();
        System.out.println(read);
    }
}
