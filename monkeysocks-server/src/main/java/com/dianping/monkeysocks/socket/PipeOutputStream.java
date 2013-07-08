package com.dianping.monkeysocks.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:36 <br>
 */
public class PipeOutputStream extends OutputStream{

    private ByteBuffer byteBuffer;

    public PipeOutputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public void write(int b) throws IOException {
        byteBuffer.put((byte)b);
    }
}
