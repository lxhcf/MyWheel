package com.example.fourComponentsUtils;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.xiruo.lxwheel.R;

/**
 * 用途:该后台服务工具类的作用是在后台开启一个播放音乐的线程
 * 使用:1.在manifest文件中注册该服务
 * <service android:enabled="true" android:name="com.example.xiruo.lxwheel.fourComponentsTest.AudioSrv" />
 *      2.在activity中新建一个指向该后台服务的intent
 *      3.调用activity.this.startService(intent);方法开启后台服务,则调用该类的onCreate和onStartCommand
 *      4.调用activity.this.stopService(intent)方法时停止后台服务
 * 注意:进行耗时操作时,要开启子线程,此时用intentService较佳,能自动创建\开启和关闭子线程
 */
public class ServiceUtil extends Service{
    MediaPlayer play;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 后台服务被创建的时候触发
     */
    public void onCreate() {
        super.onCreate();
        play = MediaPlayer.create(this, R.raw.mtest2);
        Toast.makeText(this, "创建后台服务...", Toast.LENGTH_LONG).show();
    }

    /**
     * 这里放后台服务的具体操作
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        play.start();
        Toast.makeText(this, "启动后台服务程序，播放音乐...",
                Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    /**
     * 当activity的stopService方法调用的时候该方法被调用
     */
    public void onDestroy() {
        play.release();
        super.onDestroy();
        Toast.makeText(this, "销毁后台服务！", Toast.LENGTH_LONG).show();
    }
}
