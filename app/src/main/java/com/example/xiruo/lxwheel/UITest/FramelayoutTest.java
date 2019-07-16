package com.example.xiruo.lxwheel.UITest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.viewUtils.MovableView;
import com.example.xiruo.lxwheel.R;

public class FramelayoutTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameout_test);
        FrameLayout frameLayout=(FrameLayout)findViewById(R.id.mylayout);	// 获取帧布局管理器
        final MovableView movableView=new MovableView(this,R.mipmap.rabbit);
        frameLayout.addView(movableView);
        movableView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                movableView.bitmapX=event.getX();			// 设置小兔子显示位置的X坐标
                movableView.bitmapY=event.getY();			// 设置小兔子显示位置的Y坐标
                movableView.invalidate();					//重绘rabbit组件
                return true;
            }
        });
    }
}
