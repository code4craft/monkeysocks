package com.dianping.monkeysocks.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:20 <br>
 */
public class PipeLineSocket extends Socket{

    private PipeInputStream inputStream;

    private PipeOutputStream outputStream;

    private ByteBuffer byteBuffer;

    public PipeLineSocket(){
        byteBuffer=ByteBuffer.allocate(10000);
        inputStream=new PipeInputStream(byteBuffer);
        outputStream = new PipeOutputStream(byteBuffer);

    }

    @Override
    public InputStream getInputStream() throws IOException {
        return inputStream;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return outputStream;
    }
}
