package com.example.listener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.messager_reminder.LxNotification;
import com.example.xiruo.lxwheel.MainActivity;
import com.example.xiruo.lxwheel.R;

/**
 * Created by XiRuo on 2019/7/12.
 * 用途:该类LxListener继承BroadcastReceiver,用来监听intent传来的动作
 * 使用:1.修改该类下的动作名称
 *      2.在mainifest中注册广播
 *      <receiver
 *             android:name=".LxListener"
 *             android:enabled="true"
 *             android:exported="true">
 *             <intent-filter>
 *                 <action android:name="lxTest"></action>
 *             </intent-filter>
 *      </receiver>
 */
public class LxListener extends BroadcastReceiver {
    private static final String action1 = "lxTest";//声明监听的动作

    /**
     * 该类虽无需被实例化,但构造函数私有会导致无法再线程里开启这个广播
     */
    public LxListener(){
    }

    /**
     *重写onReceive,用来处理接收的指定的intent动作
     * @param context:上下文对象
     * @param intent:消息传递的载体
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action1)) {
            Toast.makeText(context, "收到广播",
                    Toast.LENGTH_SHORT).show(); //回复该动作收到广播
//            LxNotification ln=new LxNotification(context, R.mipmap.ic_launcher,0x124);
//            ln.create("标题","内容",System.currentTimeMillis()+3000, MainActivity.class);
        }
    }
}
