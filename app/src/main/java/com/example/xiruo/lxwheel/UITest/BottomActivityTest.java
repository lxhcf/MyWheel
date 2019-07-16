package com.example.xiruo.lxwheel.UITest;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.xiruo.lxwheel.R;

/**
 * 底部导航栏实现步骤
 * 1.创建一个menu文件,用来指定底部有几个切换按钮,分别对应的标签,并将该文件与该activity中的BottomNavigationView标签绑定
 * <android.support.design.widget.BottomNavigationView
 *         android:id="@+id/bnv"
 *         android:layout_width="match_parent"
 *         android:layout_height="match_parent"
 *         android:layout_weight="5"
 *         app:menu="@menu/bottom_menu">
 * 2.创建几个fragment页面分别用来显示不同页面的内容
 * 3.在该Activity初始化控件,并设定初始的页面
 * 4.给底部导航栏设置监听事件
 */
public class BottomActivityTest extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private  Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_test);
        initFragment();
    }
    private void initFragment()
    {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragments = new Fragment[]{fragment1,fragment2,fragment3};
        lastfragment=0;
        /**
         * 1.初始化显示的页面
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment1).show(fragment1).commit();
                bottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv);
        /**
         *给切换界面设置监听事件
         */
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected( MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.id1:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;
                    }

                    return true;
                }
                case R.id.id2:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.id3:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }


            }


            return false;
        }
    };
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.mainview,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }
}
