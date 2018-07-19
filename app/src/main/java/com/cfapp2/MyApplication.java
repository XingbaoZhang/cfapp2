package com.cfapp2;

import android.app.Application;

import com.xuhao.android.libsocket.sdk.OkSocket;

/**
 * Created by Administrator on 2018-07-19.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();    //在主进程初始化一次,多进程时需要区分主进程.
//        OkSocket.initialize(this);
        //如果需要开启Socket调试日志,请配置
        OkSocket.initialize(this, true);
    }
}
