package com.example.xiruo.lxwheel.NotifyTest;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.messager_reminder.LxNotification;
import com.example.messager_reminder.NotificationUtil;
import com.example.xiruo.lxwheel.R;

public class NotificationTest extends AppCompatActivity implements View.OnClickListener{
    private NotificationManager mManager;
    private Button sendn;
    public static final String id = "channel_1";
    public static final String name = "名字";
    private NotificationUtil notificationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        sendn = findViewById(R.id.send_notice);
        sendn.setOnClickListener(this);

//        Log.d("Main", "1" );
//        LxNotification ln=new LxNotification(this,R.mipmap.ic_launcher,3);
//        ln.create("标题","内容",System.currentTimeMillis()+3000, MainActivity.class);
//        ln.postNotification(MainActivity.class);
        Log.d("Main", "2" );


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                NotificationUtil notificationUtils = new NotificationUtil(this);
                notificationUtils.sendNotification("测试标题", "测试内容");
        }
    }


}
