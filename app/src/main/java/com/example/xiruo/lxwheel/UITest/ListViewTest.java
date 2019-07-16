package com.example.xiruo.lxwheel.UITest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.xiruo.lxwheel.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建列表视图步骤
 * 1.创建一个单行布局文件 main.xml
 * 2.实例化一个适配器对象
 * 3.找到当前布局文件中listview.给他设置对应的适配器
 */
public class ListViewTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        String result="滑坡点1,滑坡点2,滑坡点3,落石点1,落石点2,落石点3";
        List<String> gameids = java.util.Arrays.asList(result.split(","));
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>(); // 创建一个list集合 用来打包存放数据源
        for (int i = 0; i < gameids.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>(); // 实例化Map对象
//                                map.put("number", String.valueOf(i));
            map.put("data1", String.valueOf(i)+"."+ gameids.get(i));
            map.put("data2", String.valueOf(i));

            listItems.add(map); // 将map对象添加到List集合中
        }
        /**
         * SimpleAdapter有五个参数
         * 1)上下文对象
         * 2)List<Map<String, Object>>对象用来存放列表数据项
         * 3)布局文件:单行列表项的样式
         * 4)字符串数组,就是list中的key,可以用来取list中的值,对应每一行上textview的数值
         * 5)布局文件中textview的id
         */
        SimpleAdapter adapter = new SimpleAdapter(ListViewTest.this, listItems,
                R.layout.main,
                new String[] { "data1","data2"},
                new int[] {R.id.title ,R.id.mybtn}); // 创建SimpleAdapter
        ListView listview = (ListView) findViewById(R.id.my_list_view); // 获取列表视图
        listview.setAdapter(adapter); // 将适配器与ListView关联
    }
}
