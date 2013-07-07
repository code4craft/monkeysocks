package com.dianping.monkeysocks.server;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-7 <br>
 * Time: 下午7:22 <br>
 */
public interface TCPServer {

    public TCPServer input(InputStream inputStream);

    public TCPServer output(OutputStream outputStream);

    public int getPort();

    public void start();

}
