package com.example.xiruo.lxwheel.UITest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.xiruo.lxwheel.R;

public class ActionBarTest4 extends AppCompatActivity {
    ImageView imageView; //定义 ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test5);
        imageView= (ImageView) findViewById(R.id.imageView); //获取朋友圈图片
        imageView.setOnClickListener(new View.OnClickListener() { //为图片设置单击事件
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActionBarTest4.this,SonActivityTest.class); //创建Intent对象
                startActivity(intent); //启动Activity

            }
        });
    }
}
