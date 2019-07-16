package com.example.xiruo.lxwheel.UITest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.example.xiruo.lxwheel.R;

public class TopTabTest extends AppCompatActivity {
    private TabHost tabHost;//声明TabHost组件的对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_tab_test);
        /**
         * 初始化tabhost
         */
        tabHost = (TabHost) findViewById(android.R.id.tabhost);//获取TabHost对象
        tabHost.setup();//初始化TabHost组件
        /**
         * 添加子界面
         */
        LayoutInflater inflater = LayoutInflater.from(this);    // 声明并实例化一个LayoutInflater对象
        inflater.inflate(R.layout.tab1, tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("精选表情")
                .setContent(R.id.linearlayout1));//添加第一个标签页
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("投稿表情")
                .setContent(R.id.framelayout));//添加第二个标签页

    }
}
