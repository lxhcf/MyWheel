package com.example.xiruo.lxwheel.WebConnectionTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
  import org.json.JSONArray;
  import org.json.JSONException;
 import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xiruo.lxwheel.R;

import java.io.UnsupportedEncodingException;

/**
 * volley工作原理:
 * 1.主线程发起一条http请求
 * 2.请求添加到缓存队列
 * 3.缓存调度线程从队列中取出一个请求,在缓存中解析并响应请求
 * 4.将解析后的响应发送主线程
 */
public class VolleyTest extends AppCompatActivity {
    Button volleyBtn;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_test);
        volleyBtn=(Button)findViewById(R.id.button);
        txt = (EditText)findViewById(R.id.editText);
        volleyBtn.setOnClickListener(new mClick());

    }
    class mClick implements View.OnClickListener
    {
        String str;
        @Override
        public void onClick(View v) {
            if(v == volleyBtn){
                /**
                 * 获取一个请求队列对象RequestQueue,管理http请求;它可以缓存所有的http请求,然后按一定的算法并发发出这些请求
                 * 并发是指两个任务都请求运行，处理器安排轮流运行，只不过切换速度很快，让人感觉两个任务都在运行。
                 */
                RequestQueue mQueue = Volley.newRequestQueue(VolleyTest.this);
                /**
                 * StringRequest用来发出一条请求
                 * 使用:1)参数1是地址
                 *      2)参数2是服务器响应成功的回调
                 *      3)参数3是服务器响应失败的回调
                 */
                StringRequest stringRequest = new StringRequest(
                        "http://39.106.90.146:8080/MyServlet/DaiBanShiJian",
                        new Response.Listener<String>() {  //volley的监听器,

                            @Override
                            public void onResponse(String response)
                            {  txt.setText(response); }// onResponse()方法获取接收到的数据值
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {  Log.e("TAG", error.getMessage(), error); }
                        }) {
                    //volley默认编码是iso,因此显示数字会出现乱码,以下将iso编码格式转换为utf8
                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        try {
                            String jsonString = new String(response.data, "UTF-8");
                            return Response.success(jsonString,
                                    HttpHeaderParser.parseCacheHeaders(response));
                        } catch (UnsupportedEncodingException e) {
                            return Response.error(new ParseError(e));
                        } catch (Exception je) {
                            return Response.error(new ParseError(je));
                        }
                    }
                } ;
                mQueue.add(stringRequest);
            } // if_end
        }   //onClick()_end
    }  //class  mClick_end

}
