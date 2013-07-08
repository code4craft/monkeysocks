package com.dianping.monkeysocks.socket;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:35 <br>
 */
public class PipeInputStream extends InputStream {

    private ByteBuffer byteBuffer;

    public PipeInputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public int read() throws IOException {
        return byteBuffer.get();
    }
}
