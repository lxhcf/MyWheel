package com.example.viewUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.xiruo.lxwheel.R;

/**
 * 用途:该类是用来在界面上创建一个可移动的图标
 * 使用:1实例化对象
 *      2.设置单击事件
 *      movableView.setOnTouchListener(new View.OnTouchListener() {
 *             @Override
 *             public boolean onTouch(View v, MotionEvent event) {
 *                 movableView.bitmapX=event.getX();			// 设置小兔子显示位置的X坐标
 *                 movableView.bitmapY=event.getY();			// 设置小兔子显示位置的Y坐标
 *                 movableView.invalidate();					//重绘rabbit组件
 *                 return true;
 *             }
 *         });
 *       3.把当前对象添加到布局管理器中
 *       frameLayout.addView(movableView);
 */

public class MovableView extends View {
    public float bitmapX;                        // 兔子显示位置的X坐标
    public float bitmapY;                        // 兔子显示位置的Y坐标
    Paint paint;
    Bitmap bitmap;
    public MovableView(Context context,int res) {
        super(context);
        bitmapX = 290;                            // 设置兔子的默认显示位置的X坐标
        bitmapY = 130;                            // 设置兔子的默认显示位置的Y坐标
        paint = new Paint();                    // 创建并实例化Paint的对象
        bitmap = BitmapFactory.decodeResource(this.getResources(),res); 					// 根据图片生成位图对象
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint); // 绘制小兔子
        if (bitmap.isRecycled()) { 					// 判断图片是否回收
            bitmap.recycle();					// 强制回收图片
        }
    }

}
