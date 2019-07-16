package com.example.xiruo.lxwheel.fourComponentsTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xiruo.lxwheel.R;

public class ActivityIntentTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_test);
        /**
         * 接收数据:
         *   Intent intent = getIntent();
         *   int a = intent.getIntExtra("a", 0);
         */
        Intent intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        /**
         * 回传数据:
         *  intent.putExtra("c", 6); //将计算的值回传回去
         *  setResult(2, intent);
         *  finish();
         */

        intent.putExtra("c", 6); //将计算的值回传回去
        setResult(2, intent);
        finish();
    }
}
