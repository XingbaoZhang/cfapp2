package com.cfapp2;

import com.xuhao.android.libsocket.sdk.bean.ISendable;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 2018-07-19.
 */

public class TestSendData implements ISendable {
    private String str = "";

    public TestSendData(String ss) {
            str = ss;
    }

    @Override
    public byte[] parse() {
        //根据服务器的解析规则,构建byte数组
        byte[] body = str.getBytes(Charset.defaultCharset());
        ByteBuffer bb = ByteBuffer.allocate(body.length);
        bb.put(body);
        return bb.array();
    }
}
