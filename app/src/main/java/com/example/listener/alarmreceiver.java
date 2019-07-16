package com.example.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class alarmreceiver extends BroadcastReceiver {
    private static final String action1 = "aaa";//声明监听的动作
    private static final String action2 = "repeating";//声明监听的动作
    private static final String action3= "cancel";//声明监听的动作


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action1)) {
            Toast.makeText(context, "定时操作完成",
                    Toast.LENGTH_SHORT).show(); //回复该动作收到广播
        }
        else
        {
            if(intent.getAction().equals(action2)){
                Toast.makeText(context, "重复定时操作完成",
                        Toast.LENGTH_SHORT).show(); //回复该动作收到广播
            }
            else {
                Toast.makeText(context, "取消定时操作完成",
                        Toast.LENGTH_SHORT).show(); //回复该动作收到广播
            }

        }
    }
}
