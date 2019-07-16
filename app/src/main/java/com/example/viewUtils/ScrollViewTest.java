package com.example.viewUtils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xiruo.lxwheel.R;

/**
 * 创建滚动视图
 * 1.获取布局管理器
 * 2.实例化一个滚动视图组件
 * 3.往布局管理器里添加该滚动视图
 * 4.往滚动视图里加控件即可滚动查看视图
 * 综上,若做静态页面,直接往布局文件里添加  ScrollView标签即可
 */
public class ScrollViewTest extends AppCompatActivity {
    LinearLayout linearLayout, linearLayout2;//定义linearLayout为默认布局管理器，linearLayout2为新建布局管理器
    ScrollView scrollView;//定义滚动视图组件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view_test);
        linearLayout = (LinearLayout) findViewById(R.id.ll);//获取布局管理器

        linearLayout2 = new LinearLayout( ScrollViewTest.this);//创建一个新的布局管理器
        linearLayout2.setOrientation(LinearLayout.VERTICAL);//设置为纵向排列

        scrollView = new ScrollView( ScrollViewTest.this);//创建滚动视图组件
        linearLayout.addView(scrollView);//默认布局中添加滚动视图组件
        scrollView.addView(linearLayout2);//滚动视图组件中添加新建布局

        ImageView imageView = new ImageView( ScrollViewTest.this);//创建ImageView组件
        imageView.setImageResource(R.mipmap.cidian);//ImagView添加图片

        TextView textView = new TextView( ScrollViewTest.this);//创建TextView组件
        textView.setText(R.string.cidian);//TextView添加文字

        linearLayout2.addView(imageView);//新建布局中添加ImageView组件
        linearLayout2.addView(textView);//新建布局中添加TextView组件
    }
}
