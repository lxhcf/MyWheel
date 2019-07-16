package com.example.fourComponentsUtils;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public  class IntentUtil {
    /**
     * 第一个Activity发送数据给第二个Activity
     */
    public static void sendExtraData(Context context,Class c,String key,int value){
        Intent intent=new Intent(context, c); //创建Intent对象
        intent.putExtra(key, value);
//        在这里碰到困难
//        context.startActivityForResult(intent, 1); //REQUESTCODE--->1
    }
    /**
     * 第二个Activity获取第一个Activity发送的数据
     */
    public void getExtraData(){

    }
    public void sendResult(){

    }
    public void getResult(){

    }
}
