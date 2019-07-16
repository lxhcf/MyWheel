package com.example.xiruo.lxwheel.fourComponentsTest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiruo.lxwheel.R;

public class ServiceTest extends AppCompatActivity {
    Button startbtn, stopbtn;
    Context context;
    Intent intent;
    static TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        startbtn = (Button) findViewById(R.id.butn1);
        stopbtn = (Button) findViewById(R.id.butn2);
        startbtn.setOnClickListener(new mClick());
        stopbtn.setOnClickListener(new mClick());
        txt = (TextView) findViewById(R.id.text1);
        intent = new Intent(ServiceTest.this, AudioSrv.class);

    }

    class mClick implements View.OnClickListener  //定义一个类实现监听接口
    {
        public void onClick(View v) {
            if (v == startbtn) {
                ServiceTest.this.startService(intent);
                txt.setText("start service .......");
            } else if (v == stopbtn) {
                ServiceTest.this.stopService(intent);
            }
        }
    }

}
