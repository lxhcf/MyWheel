package com.example.graphicsAndMultimedia;

import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * 用途:在屏幕上生成一个小球,并且可以根据设置的属性移动位置
 * 使用步骤:1.在布局文件中加入该自定义的view
 *          <com.example.graphicsAndMultimedia.PainBallUtils
 *         android:id="@+id/testView1"
 *         android:layout_width="match_parent"
 *         android:layout_height="match_parent" />
 *         或定义在一个帧布局中加入该view,参考moveableView类的使用
 *         2.实例化对象
 *         3.调用setXY方法传入x,y坐标
 *         4.调用invalidate方法刷新重新绘制
 */
public class PainBallUtils extends View {
    private int x, y;
    public PainBallUtils(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setXY(int _x, int _y) {
        x = _x;
        y = _y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*设置背景为青色*/
        canvas.drawColor(Color.CYAN);
        Paint paint = new Paint();
        /*去锯齿*/
        paint.setAntiAlias(true);
        /*设置paint的颜色*/
        paint.setColor(Color.BLACK);
        /*画一个实心圆*/
        canvas.drawCircle(x, y, 15, paint);
        /*画一个实心圆上的小白点*/
        paint.setColor(Color.WHITE);
        canvas.drawCircle(x - 6, y - 6, 3, paint);

    }
}
