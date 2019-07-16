package com.example.xiruo.lxwheel.UITest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.xiruo.lxwheel.R;

/**
 * 使用:1.显示actionBar:在manifest中对应的activity 添加theme和lable属性
 *      2.隐藏actionBar中的lable:        getSupportActionBar().setDisplayShowTitleEnabled(false);
 *      3.创建actionBar上的选项:
 *          1).创建item的menu文件 参照mymenu
 *          2).重写onCreateOptionsMenu方法
 *      4.创建actionBar上的actionView(例如搜索框):
 *          1).创建item的menu文件(参照munu文件)
 *          2).重写onCreateOptionsMenu方法
 *
 */
public class ActionBarTest1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test1);
        //隐藏ActionBar中显示的标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();  //实例化一个MenuInflater对象
        inflater.inflate(R.menu.menu,menu);       //解析菜单文件
        return super.onCreateOptionsMenu(menu);
    }
}
