package com.example.messager_reminder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.xiruo.lxwheel.MainActivity;
import com.example.xiruo.lxwheel.NotifyTest.NotificationTest;

import static android.content.Context.NOTIFICATION_SERVICE;
/**
 * 用途:LxNotification该类是用来再主界面弹出一个通知
 * 使用:1.实例化LxNotification对象传入三个参数:1)context:上下文对象
 *                                             2)res:图标资源文件,设置通知的样式
 *                                             3)notifyId:通知的id,在应用中是唯一的
 *      2.调用create方法,传入三个参数:1)ContentTitle:通知的标题
 *                                    2)ContentText:通知的内容
 *                                    3)time:何时启动通知
 *                                    4)targetContext:想要跳转的界面
 */


public class LxNotification {
    protected  NotificationManager notificationManager;
    private  Context context;
    private int res;
    private int notifyId;
    Boolean isAutoCancel=true;
    private static final int NOTIFICATION_FLAG = 1;
    //
    Notification.Builder builder;
    public LxNotification(Context context,int res,int notifyId) {
        this.context=context;
        this.res=res;
        this.notifyId=notifyId;
    }

    public void create1(String ContentTitle,String ContentText,long time,Class targetContext){
        notificationManager =(NotificationManager)
                context.getSystemService(NOTIFICATION_SERVICE); //获取通知管理器，用于发送通知
        Notification.Builder notification = new Notification.Builder(this.context); // 创建一个Notification对象
        notification.setAutoCancel(isAutoCancel); // 设置打开该通知，该通知自动消失
//        notification.setSmallIcon(res);
//        notification.setContentTitle(ContentTitle); // 设置通知内容的标题
//        notification.setContentText(ContentText);// 设置通知内容
        notification.setDefaults(Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE);  //设置使用系统默认的声音、默认震动
        notification.setWhen(time);//设置发送时间
//        Intent intent = new Intent(this.context,targetContext);// 创建一个启动其他Activity的Intent
//        PendingIntent pi = PendingIntent.getActivity(
//                this.context, 0, intent, 0);
//        notification.setContentIntent(pi); //设置通知栏点击跳转
        notificationManager.notify(notifyId, notification.build());
    }

    public void postNotification(Class targetContext) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("lx", "s",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            builder = new Notification.Builder(context, "lx");
        }else {
            builder = new Notification.Builder(context);
        }
        //需要跳转指定的页面
        Intent intent = new Intent(context, targetContext);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        builder.setTicker("new message")
                .setSmallIcon(res)
                .setContentTitle("标题")
                .setContentText("内容")
                .setContentIntent(pendingIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void create(String ContentTitle, String ContentText, long time, Class targetContext){

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 0,new Intent(this.context,targetContext), 0);
        Notification notify = new Notification.Builder(context)
                .setSmallIcon(res)
                .setTicker("TickerText:" + "您有新短消息，请注意查收！")
                .setContentTitle(ContentTitle)
                .setContentText(ContentText)
                .setContentIntent(pendingIntent).setNumber(1).build(); // 需要注意build()是在API
        // level16及之后增加的，API11可以使用getNotificatin()来替代
        notify.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
        // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
        NotificationManager manager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel =new NotificationChannel("channel_01","消息推送", NotificationManager.IMPORTANCE_DEFAULT);
        manager.createNotificationChannel(mChannel);
        manager.notify(notifyId, notify);// 步骤4：通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
    }
//    public void create(String ContentTitle,String ContentText){
//        notificationManager =(NotificationManager)
//                context.getSystemService(NOTIFICATION_SERVICE); //获取通知管理器，用于发送通知
//        Notification.Builder notification = new Notification.Builder(this.context); // 创建一个Notification对象
//        notification.setAutoCancel(isAutoCancel); // 设置打开该通知，该通知自动消失
//        notification.setSmallIcon(res);
//        notification.setContentTitle(ContentTitle); // 设置通知内容的标题
//        notification.setContentText(ContentText);// 设置通知内容
//        notification.setDefaults(Notification.DEFAULT_SOUND
//                | Notification.DEFAULT_VIBRATE);  //设置使用系统默认的声音、默认震动
//        notificationManager.notify( notifyId, notification.build());
//    }


}
