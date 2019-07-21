package com.example.xiruo.lxwheel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.viewUtils.ScrollViewTest;
import com.example.xiruo.lxwheel.NotifyTest.AlarmTest;
import com.example.xiruo.lxwheel.NotifyTest.NotificationTest;
import com.example.xiruo.lxwheel.UITest.APPUpdate;
import com.example.xiruo.lxwheel.UITest.ActionBarTest1;
import com.example.xiruo.lxwheel.UITest.ActionBarTest2;
import com.example.xiruo.lxwheel.UITest.ActionBarTest3;
import com.example.xiruo.lxwheel.UITest.ActionBarTest4;
import com.example.xiruo.lxwheel.UITest.BottomActivityTest;
import com.example.xiruo.lxwheel.UITest.ContextMenuTest;
import com.example.xiruo.lxwheel.UITest.LeftListTest;
import com.example.xiruo.lxwheel.UITest.ListViewTest;
import com.example.xiruo.lxwheel.UITest.TopTabTest;
import com.example.xiruo.lxwheel.WebConnectionTest.VolleyTest;
import com.example.xiruo.lxwheel.graphicsAndMultimediaTest.TakingPhotoTest;

public class MainActivity extends AppCompatActivity {
    private String picPath = null;
    public static final int TO_SELECT_PHOTO = 3;
    ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btnTest);//获取布局文件中的广播按钮
        Button button2 = (Button) findViewById(R.id.btnTest2);//获取布局文件中的广播按钮
        ivImage = (ImageView) this.findViewById(R.id.ivImage);
        button.setOnClickListener(new View.OnClickListener() {  //为按钮设置单击事件
            @Override
            public void onClick(View v) {
                //region 广播测试(通过)
                //广播Test开始-------------------------------------
//                Intent intent=new Intent(MainActivity.this,LxListenerTest.class); //测试LxListenerTest
//                startActivity(intent);
                //广播Test结束-------------------------------------
                //endregion()

                //region 通知测试(通过)
//                Intent intent=new Intent(MainActivity.this, NotificationTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion()

                //region 提示框测试1普通对话框-------------(通过)
//                LxAlertDialog lxAlertDialog=new LxAlertDialog(MainActivity.this);
//                lxAlertDialog.setBtnClickListener(-1,"确定",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "您单击了确定按钮", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                lxAlertDialog.create("标题","内容");
                //endregion()

                //region 提示框测试2列表提示框---------通过
//                final String[] items = new String[]{"当你有使命，它会让你更专注", "要么出众，要么出局", "活着就是为了改变世界",
//                        "求知若饥，虚心若愚"};
//                LxAlertDialog lxAlertDialog = new LxAlertDialog(MainActivity.this);
//                lxAlertDialog.createListAD("标题", items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,
//                                "您选择了" + items[which], Toast.LENGTH_SHORT).show();
//                    }
//                });
                //endregion

                //region 提示框测试3单选项提示框-------通过
//                final String[] items = new String[]{"当你有使命，它会让你更专注", "要么出众，要么出局", "活着就是为了改变世界",
//                        "求知若饥，虚心若愚"};
//                final LxAlertDialog lxAlertDialog = new LxAlertDialog(MainActivity.this);
//                lxAlertDialog.createSingleChoiceListAD("标题",items,new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,
//                                "您选择了" +items[lxAlertDialog.selectedIndex], Toast.LENGTH_SHORT).show();    //显示选择结果
//                    }
//                });
                //endregion

                //region 提示框测试4多选提示框-------------通过
//                final String[] items = new String[]{"开心消消乐", "球球大作战", "欢乐斗地主", "梦幻西游", "超级玛丽"};
//                final LxAlertDialog lxAlertDialog = new LxAlertDialog(MainActivity.this);
//                lxAlertDialog.createMulChoiceListAD("标题",items,new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                       String result=" ";
//                        for (int i:lxAlertDialog.selectedIndexs ) {
//                            result+=String.valueOf(items[i])+",";
//                        }
//                        Toast.makeText(MainActivity.this,
//                                "您选择了[ " + result + " ]", Toast.LENGTH_LONG).show();
//                    }
//                });
                //endregion


                //region 数据库
                //region 数据库测试1---------------------------SQLite(通过)
//                Intent intent=new Intent(MainActivity.this, DBTestActivity.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 数据库测试2---------------------------File(通过)----(有动态校验权限的程序)
//                Intent intent=new Intent(MainActivity.this, FileReadTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 数据库测试3--------------------------SharedPreferences(通过)
//                SharedPreferenceUtils sharedPreferenceUtils = new SharedPreferenceUtils(MainActivity.this, "phoneBook");
//                String a = sharedPreferenceUtils.get("name");
//                Log.d("main", "a=============" + a);
//                sharedPreferenceUtils.write("sex", "男");
//                String b = sharedPreferenceUtils.get("sex");
//                Log.d("main", "b=============" + b);
//                sharedPreferenceUtils.remove("sex");
//                String c = sharedPreferenceUtils.get("sex");
//                Log.d("main", "c=============" + c);
                //endregion
                //endregion

                //region 联网测试1---------------------------WebView 不能打开网页
//                Intent intent=new Intent(MainActivity.this, WebViewActivity.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计
                //region UI设计---------------------------帧布局管理器(重叠放置,类似贴纸) 小兔子移动(通过)
//                Intent intent=new Intent(MainActivity.this, FramelayoutTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------相对布局管理器 更新app(通过)+一个进度条
//                Intent intent=new Intent(MainActivity.this, APPUpdate.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------帧布局管理器 登陆(通过)
//                Intent intent=new Intent(MainActivity.this, LoginTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------表格布局管理器 喜马拉雅登陆(通过)
//                Intent intent=new Intent(MainActivity.this, LoginMulETest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------表格布局管理器 聊天(通过)
//                Intent intent=new Intent(MainActivity.this, ChatTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------表格布局管理器 微信朋友圈(未通过)
//                Intent intent=new Intent(MainActivity.this, ChatTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------上下文菜单(通过)
//                Intent intent=new Intent(MainActivity.this, ContextMenuTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------ActionBar--知乎界面的实现(通过)
//                Intent intent=new Intent(MainActivity.this, ActionBarTest1.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------TabActionBar--有道词典界面切换(通过)
//                Intent intent=new Intent(MainActivity.this, ActionBarTest2.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------顶部tabTab (通过)
//                Intent intent=new Intent(MainActivity.this, TopTabTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion


                //region UI设计---------------------------底部tabTab  BottomNavigationView--奥克斯切换(未通过)
//                Intent intent=new Intent(MainActivity.this, ActionBarTest3.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------底部导航栏2  (通过)
//                Intent intent=new Intent(MainActivity.this, BottomActivityTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------下拉列表  (未通过)
                Intent intent=new Intent(MainActivity.this, LeftListTest.class); //创建Intent对象
                startActivity(intent);
                //endregion

                //region UI设计---------------------------层式导航(通过)
//                Intent intent=new Intent(MainActivity.this, ActionBarTest4.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------列表视图(通过)
//                Intent intent=new Intent(MainActivity.this, ListViewTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region UI设计---------------------------滚动视图未(通过)
//                Intent intent=new Intent(MainActivity.this, ScrollViewTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion


                //endregion

                //region 动画与多媒体
                //region 动画设计--------------------------- 指定位置画圆(通过)
//                Intent intent=new Intent(MainActivity.this, PaintBallTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 动画设计--------------------------- 涂鸦(通过)--未审查
//                Intent intent=new Intent(MainActivity.this, GrafftitiTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 动画设计--------------------------- 手势识别(暂时搁置)
//                Intent intent=new Intent(MainActivity.this, GestureRecognitionTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 音频播放----------------------- 音乐播放(通过)
//                Intent intent=new Intent(MainActivity.this, MusicPlayerTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 音频播放----------------------- 视频播放使用VideoView能自适应视频大小不会拉伸(通过)
//                Intent intent=new Intent(MainActivity.this, VideoPlayerTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 录音----------------------(通过)
//                Intent intent=new Intent(MainActivity.this, RecordTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 拍照----------------------(通过)
//                Intent intent=new Intent(MainActivity.this, TakingPhotoTest.class); //创建Intent对象
//                startActivityForResult(intent,TO_SELECT_PHOTO);
                //endregion
                //endregion

                //region 四大组件
                //region 四大组件----------------------activity的生命周期和通信(通过)
//                Intent intent = new Intent(MainActivity.this, ActivityTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 四大组件----------------------service 后台音乐播放(通过)
//                Intent intent = new Intent(MainActivity.this, ServiceTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 四大组件----------------------service bound service_彩票选号(通过)
//                Intent intent = new Intent(MainActivity.this, ServiceTest2.class); //创建Intent对象
//                startActivity(intent);
                //endregion

                //region 四大组件----------------------定时通知(通过)-----------------------未整理
//                Intent intent = new Intent(MainActivity.this, AlarmTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion
                //endregion

                //region 四大组件----------------------volley网络
//                Intent intent = new Intent(MainActivity.this, VolleyTest.class); //创建Intent对象
//                startActivity(intent);
                //endregion

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode== Activity.RESULT_OK && requestCode == TO_SELECT_PHOTO)
        {
            picPath = data.getStringExtra(TakingPhotoTest.KEY_PHOTO_PATH);
            Bitmap bm = BitmapFactory.decodeFile(picPath);
            ivImage.setImageBitmap(bm);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
