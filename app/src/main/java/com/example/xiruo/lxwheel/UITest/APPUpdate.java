package com.example.xiruo.lxwheel.UITest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xiruo.lxwheel.R;
import com.example.xiruo.lxwheel.WebConnectionTest.WebViewActivity;

public class APPUpdate extends AppCompatActivity {
    private ProgressBar horizonP;            //水平进度条
    private int mProgressStatus = 0;        //完成进度
    private static Handler mHandler;            //声明一个用于处理消息的Handler类的对象
    Button openWebBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appupdate);
        horizonP = (ProgressBar) findViewById(R.id.progressBar1);    //获取水平进度条
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x111) {
                    horizonP.setProgress(mProgressStatus);    //更新进度
                } else {
                    Toast.makeText(APPUpdate.this, "耗时操作已经完成", Toast.LENGTH_SHORT).show();
                    horizonP.setVisibility(View.GONE);    //设置进度条不显示，并且不占用空间
                }
            }
        };
        openWebBtn = (Button) findViewById(R.id.button1);
        openWebBtn.setOnClickListener(new APPUpdate.mClick());

    }
    class mClick implements View.OnClickListener {
        public void onClick(View arg0) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        mProgressStatus = doWork();    //获取耗时操作完成的百分比
                        Message m = new Message();
                        if (mProgressStatus < 100) {
                            m.what = 0x111;
                            mHandler.sendMessage(m);    //发送信息
                        } else {
                            m.what = 0x110;
                            mHandler.sendMessage(m);    //发送消息
                            break;
                        }
                    }

                }

                //模拟一个耗时操作
                private int doWork() {
                    mProgressStatus += Math.random() * 10;    //改变完成进度
                    try {
                        Thread.sleep(200);        //线程休眠200毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return mProgressStatus;    //返回新的进度
                }
            }).start();    //开启一个线程
        }
    }

}
