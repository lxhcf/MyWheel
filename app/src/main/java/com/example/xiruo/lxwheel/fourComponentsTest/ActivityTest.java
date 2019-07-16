package com.example.xiruo.lxwheel.fourComponentsTest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.xiruo.lxwheel.R;

/**
 * 常用的生命周期：1.创建 onCreate - 2.启动onStart – 3.开始 onResume – 4.暂停 onPause – 5.结束 onStop – 6.销毁onDestroy
 * Activity第一次启动,回调如下: onCreate-->onStart --> onResume.
 * 当用户打开一个新的Activity或者按Home健回到桌面时,回调如下: onPause--> onStop.
 *当用户再次回到此Activity时,回调如下: onRestart -->onStart-->onResume.
 *当用户按返回键或者调用finish()结束此Activity时,回调如下: onPause -->onStop-->onDestroy.
 */
public class ActivityTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.d("main","1-----------onCreate");
        Button button = (Button) findViewById(R.id.btnTest);//获取布局文件中的广播按钮
        button.setOnClickListener(new View.OnClickListener() {  //为按钮设置单击事件
            @Override
            public void onClick(View v) {
                /**
                 * sendExtraData分三步:
                 * 1.初始化一个intent对象
                 * 2.存放数据 1)     intent.putExtra("a", 11);有数据大小限制
                 *            2)    Bundle bundle = new Bundle();
                 *                  bundle.putString("flag",flag);
                 *                intent.putExtras(bundle);
                 * 3.启动intent
                 */
                Intent intent=new Intent(ActivityTest.this, ActivityIntentTest.class); //创建Intent对象
                intent.putExtra("a", 11);
                startActivityForResult(intent, 1); //REQUESTCODE--->1
            }
        });
    }

    /**
     * getResult分为三步:
     * 1.判断是从第二个activity哪个intent返回的请求
     * 2.判断是第一个activity中哪个intent发送的请求
     * 3.获取数据: 1)data.getIntExtra
     *             2) Bundle bundle = this.getIntent().getExtras();
     * //             String str=bundle.getString("flag")
     * @param requestCode:用来区分发送的请求
     * @param resultCode:用来区分返回的请求
     * @param data:数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==2){
            if (requestCode==1){
                int result=data.getIntExtra("c",0);
                Log.d("main","回传的结果c===="+result);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("main","2-----------onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("main","3-----------onResume");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("main","4-----------onPause");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("main","5-----------onStop");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("main","6-----------onDestroy");

    }




}
