package com.cfapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xuhao.android.libsocket.sdk.ConnectionInfo;
import com.xuhao.android.libsocket.sdk.OkSocket;
import com.xuhao.android.libsocket.sdk.SocketActionAdapter;
import com.xuhao.android.libsocket.sdk.connection.IConnectionManager;

public class MainActivity extends AppCompatActivity {
    IConnectionManager  manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //连接参数设置(IP,端口号),这也是一个连接的唯一标识,不同连接,该参数中的两个值至少有其一不一样
        ConnectionInfo info = new ConnectionInfo("124.130.89.100", 9999);
        //调用OkSocket,开启这次连接的通道,拿到通道Manager
         manager = OkSocket.open(info);
        //注册Socket行为监听器,SocketActionAdapter是回调的Simple类,其他回调方法请参阅类文档
        manager.registerReceiver(new SocketActionAdapter(){
            @Override
            public void onSocketConnectionSuccess(Context context, ConnectionInfo info, String action) {
                Toast.makeText(context, "连接成功", Toast.LENGTH_LONG).show();
                manager = OkSocket.open(info);
                manager.send(new TestSendData("111"));
                manager.disconnect();
            }

            @Override
            public void onSocketConnectionFailed(Context context, ConnectionInfo info, String action, Exception e) {
                super.onSocketConnectionFailed(context, info, action, e);
                Toast.makeText(context, "连接失败", Toast.LENGTH_LONG).show();
                manager=null;
            }
        });
         //调用通道进行连接
        manager.connect();
    }
}
