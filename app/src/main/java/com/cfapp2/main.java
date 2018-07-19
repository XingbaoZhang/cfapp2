package com.cfapp2;

import android.app.Activity;
import android.view.View;
import android.view.Window;

/**
 * Created by Administrator on 2018-07-19.
 */

public class main extends Activity{
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
}
