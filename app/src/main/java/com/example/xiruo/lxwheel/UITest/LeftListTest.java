package com.example.xiruo.lxwheel.UITest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.xiruo.lxwheel.R;

public class LeftListTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_list_test);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);   //获取下拉列表

        //		一般不用这种方法,而是在布局资源直接绑定一个数组文件
//		String[] ctype=new String[]{"全部","电影","图书","唱片","小事","用户","小组","群聊","游戏","活动"};
//
//		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ctype);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String result = parent.getItemAtPosition(position).toString();    //获取选择项的值
                Toast.makeText(LeftListTest.this, result, Toast.LENGTH_SHORT).show(); //显示被选中的值

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
