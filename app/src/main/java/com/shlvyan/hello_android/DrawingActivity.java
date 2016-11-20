package com.shlvyan.hello_android;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class DrawingActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        init();
    }

    private void init() {
        LinearLayout layout=(LinearLayout) findViewById(R.id.activity_drawing);
        final DrawView view=new DrawView(this);
        view.setMinimumHeight(800);
        view.setMinimumWidth(600);
        //通知view组件重绘
        view.invalidate();
        layout.addView(view);

    }
}
