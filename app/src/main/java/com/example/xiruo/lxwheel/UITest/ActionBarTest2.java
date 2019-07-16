package com.example.xiruo.lxwheel.UITest;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.viewUtils.TabListenerUtil;
import com.example.xiruo.lxwheel.R;

/**
 * 生成快速生成一个actionBar,实现界面切换效果
 */
public class ActionBarTest2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test2);
        Log.d("main","1-----------------");
        /**
         * 1.实例化一个ActionBar对象
         * 2.设置为选项卡模式
         * 3.隐藏标题栏
         */
        ActionBar actionBar=getSupportActionBar(); //获取ActionBar
        //manifest中的android:theme不能为空
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);  //设置ActionBar为选项卡模式
        actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);  //隐藏标题栏
        /**
         * 4.添加界面
         */
        actionBar.addTab(actionBar.newTab().setText("词典"). //将标签页添加ActionBar中
                setTabListener(new TabListenerUtil(this, Fragment1.class)));
        actionBar.addTab(actionBar.newTab().setText("百科"). //将标签页添加ActionBar中
                setTabListener(new TabListenerUtil(this, Fragment2.class)));
        actionBar.addTab(actionBar.newTab().setText("翻译").////将标签页添加ActionBar中
                setTabListener(new TabListenerUtil(this, Fragment3.class)));
        actionBar.addTab(actionBar.newTab().setText("发现").//将标签页添加ActionBar中
                setTabListener(new TabListenerUtil(this, Fragment4.class)));
        actionBar.addTab(actionBar.newTab().setText("我的").//将标签页添加ActionBar中
                setTabListener(new TabListenerUtil(this, Fragment5.class)));

    }
}
