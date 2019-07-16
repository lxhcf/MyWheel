package com.example.xiruo.lxwheel.NotifyTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;


import com.example.listener.alarmreceiver;
import com.example.xiruo.lxwheel.R;

public class AlarmTest extends AppCompatActivity {
    Button btn1, btn2, btn3;
    Intent intent;
    PendingIntent sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_test);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new mClick());
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new mClick());
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new mClick());

    }

    class mClick implements OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    timing();
                    break;
                case R.id.btn2:
                    cycle();
                    break;
                case R.id.btn3:
                    cancel();
                    break;
            }
        }
    }

    /**
     * 定时开启动作
     *
     */
    void timing() {
        intent = new Intent(AlarmTest.this, alarmreceiver.class);
        intent.setAction("aaa");
        sender = PendingIntent.getBroadcast(AlarmTest.this, 0, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 5);
//        设定一个五秒后的时间
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                sender);
        Toast.makeText(AlarmTest.this, "五秒后alarm开启",
                Toast.LENGTH_LONG).show();
    }

    /**
     * 定义循环：每5秒发送一个广播，广播接收后Toast提示定时操作完成
     */
    void cycle() {
        Intent intent = new Intent(AlarmTest.this, alarmreceiver.class);
        intent.setAction("repeating");
        PendingIntent sender = PendingIntent.getBroadcast(AlarmTest.this,
                 0, intent, 0);
        /*  开始时间  */
        long firstime = SystemClock.elapsedRealtime();
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        /*  5秒一个周期，不停的发送广播    */
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                firstime, 5 * 1000, sender);
    }

    /**
     * 取消周期发送信息
     */
    void cancel() {
        Intent intent = new Intent(AlarmTest.this, alarmreceiver.class);
        intent.setAction("cancel");
        PendingIntent sender = PendingIntent
                .getBroadcast(AlarmTest.this, 0, intent, 0);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.cancel(sender);
    }


}
