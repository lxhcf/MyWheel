package com.example.DataBaseUtils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 用途:该类可以用SharedPreference的存储方式保存一些配置文件数据,如用户名,密码
 * 使用:1.用构造函数实例化一个对象
 *      2.调用get方法可以获取文件中的保存的数值,若没有该数据,则返回"missing"
 *      3.调用write方法可以往文件中写数据
 *      4.调用delete方法可以删除指定的数据
 */
public class SharedPreferenceUtils {
    Context context;
    String fileName;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;

    public SharedPreferenceUtils(Context context, String fileName) {
        this.context=context;
        this.fileName=fileName;
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String get(String key){
       return sharedPreferences.getString(key,"missing");
    }
    public  void write(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }
    public  void remove(String key){
        editor.remove(key);
        editor.commit();
    }

}
