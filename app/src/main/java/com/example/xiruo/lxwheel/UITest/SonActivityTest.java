package com.example.xiruo.lxwheel.UITest;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xiruo.lxwheel.R;

/**
 * 层式导航实现：
 * 1.在mainifest中给子activity指定父activity
 * <meta-data
 *             android:name="android.support.PARENT_ACTIVITY"
 *             android:value=".UITest.ActionBarTest4" />
 * 2.在子activity中添加
 *    if (NavUtils.getParentActivityName(SonActivityTest.this) != null) {
 *             getSupportActionBar().setDisplayHomeAsUpEnabled(true);    //显示向左的箭头图标
 *         }
 */
public class SonActivityTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son_test);
        if (NavUtils.getParentActivityName(SonActivityTest.this) != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);    //显示向左的箭头图标
        }
    }
}
