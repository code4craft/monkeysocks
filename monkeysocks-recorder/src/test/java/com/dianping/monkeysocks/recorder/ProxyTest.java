package com.dianping.monkeysocks.recorder;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-6 <br>
 * Time: 上午8:17 <br>
 */
public class ProxyTest {

    @Test
    public void testProxy() throws IOException {
        Properties properties = System.getProperties();
        properties.setProperty("socksProxyHost", "127.0.0.1");
        properties.setProperty("socksProxyPort", "1080");
        URL url = new URL("http://dl.360safe.com/mac/safe/360InternetSecurity.dmg");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        String s = IOUtils.toString(urlConnection.getInputStream());
        System.out.println(s.length());
    }
}
