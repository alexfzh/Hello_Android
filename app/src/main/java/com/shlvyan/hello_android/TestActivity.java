package com.shlvyan.hello_android;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    ImageView IV_2_1;
    EditText etx2;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        etx2= (EditText) findViewById(R.id.etx_2_1);
        txt1= (TextView) findViewById(R.id.TV_2_1);

        final Intent intent=this.getIntent();
        String str2= intent.getStringExtra("alex");
        IV_2_1= (ImageView) findViewById(R.id.IV_2_1);
        final AnimationDrawable anim_1= (AnimationDrawable) IV_2_1.getBackground();
        etx2.setText(str2);

        Button btn_start= (Button) findViewById(R.id.btn_start);
        Button btn_stop= (Button) findViewById(R.id.btn_stop);
        Button btn_back= (Button) findViewById(R.id.btn_back);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim_1.start();
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim_1.stop();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(TestActivity.this,MainActivity.class));
            }
        });

        etx2.addTextChangedListener(new EditChangedListener());

    }

    private class EditChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            txt1.setText(etx2.getText().toString().trim());
        }
    }
}
