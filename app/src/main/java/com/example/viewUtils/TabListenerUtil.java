package com.example.viewUtils;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

/**
 * 用途:该类为TabActionBar提供切换页面的监听
 */
public class TabListenerUtil implements ActionBar.TabListener {
    private Fragment fragment;  //定义Fragment
    private final Activity activity; //定义Activity
    private final Class aClass; //定义Class

    public TabListenerUtil(Activity activity, Class aClass) { //添加构造函数
        this.activity = activity;
        this.aClass = aClass;
    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //判断碎片是否初始化
        if (fragment == null) { //如果没有初始化，将其初始化
            fragment = Fragment.instantiate(activity, aClass.getName());
            ft.add(android.R.id.content, fragment, null);
        }
        ft.attach(fragment); //显示新画面
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (fragment != null) {
            ft.detach(fragment); //删除旧画面
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
