package com.example.xiruo.lxwheel.fourComponentsTest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 用途:该后台服务类能与activity交互数据
 * 使用:1.在minifest文件中添加
 *          <service
 *             android:name="com.example.xiruo.lxwheel.fourComponentsTest.BinderService"
 *             android:enabled="true"
 *             android:exported="true">
 *         </service>
 *      2. 在activity中1)创建BinderService对象
 *                     2)创建ServiceConnection对象,该对象实现ServiceConnection接口,重写onServiceConnected方法,用来获取后台服务的信息
 *      3. 在activity的onstart方法中,1)创建一个intent对象,指向后台服务
 *                                   2)绑定指定的service:调用activity对象的bindService(intent, conn, BIND_AUTO_CREATE);
 *      4.在activity的onStop方法里断开activity与后台服务的连接: unbindService(conn);
 *      5.调用BinderService对象的方法就可以正常使用该类对象就像使用普通类一样,而不是像ServiceUtil挂起一个后台服务
 */
public class BinderService extends Service {
    public BinderService() {
    }
    public class MyBinder extends Binder {  //创建MyBinder内部类并获取服务对象与Service状态
        public BinderService getService() {  //创建获取Service的方法
            return BinderService.this;       //返回当前Service类
        }
    }

    /**
     * 当返回值不为null时,说明和intent发出的activity绑定
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {  //必须实现的绑定方法
        return new MyBinder();  //返回MyBinder服务对象
    }

    /**
     * 获取随机号码
     * @return
     */
    public List getRandomNumber() {  //创建获取随机号码的方法
        List resArr = new ArrayList();   //创建ArrayList数组
        String strNumber="";
        for (int i = 0; i < 7; i++) {  //将随机获取的数字转换为字符串添加到ArrayList数组中
            int number = new Random().nextInt(33) + 1;
            //把生成的随机数格式化为两位的字符串
            if (number<10) {  //在数字1~9前加0
                strNumber = "0" + String.valueOf(number);
            } else {
                strNumber=String.valueOf(number);
            }
            resArr.add(strNumber);
        }
        return resArr;  //将数组返回
    }


    @Override
    public void onDestroy() {  //销毁该Service
        super.onDestroy();
    }
}
