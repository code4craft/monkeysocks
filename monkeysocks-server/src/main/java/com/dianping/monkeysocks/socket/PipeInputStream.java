package com.dianping.monkeysocks.socket;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-8 <br>
 * Time: 下午8:35 <br>
 */
public class PipeInputStream extends InputStream {

    private StreamBuffer streamBuffer;

    public PipeInputStream(StreamBuffer streamBuffer) {
        this.streamBuffer = streamBuffer;
    }

    @Override
    public  int read() throws IOException {
        return streamBuffer.read();
    }
}
