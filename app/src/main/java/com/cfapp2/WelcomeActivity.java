package com.cfapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018-07-19.
 */

public class WelcomeActivity extends Activity{
    LinearLayout dj;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        dj=findViewById(R.id.dj);
        dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            }
        });
    }
}
