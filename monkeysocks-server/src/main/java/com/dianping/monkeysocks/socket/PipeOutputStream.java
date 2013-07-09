package com.dianping.monkeysocks.socket;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:36 <br>
 */
public class PipeOutputStream extends OutputStream{

    private StreamBuffer streamBuffer;

    public PipeOutputStream(StreamBuffer streamBuffer) {
        this.streamBuffer = streamBuffer;
    }

    @Override
    public void write(int b) throws IOException {
        streamBuffer.write((byte)b);
    }
}
