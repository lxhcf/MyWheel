package com.example.xiruo.lxwheel.DBTest;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.DataBaseUtils.FileUtils;
import com.example.xiruo.lxwheel.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadTest extends AppCompatActivity {
    Button saveBtn, readBtn, savesdBtn, readsdBtn;
    EditText edit;
    String fileName = "test.txt";
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read_test);
        edit = (EditText) findViewById(R.id.edit1);
        saveBtn = (Button) findViewById(R.id.button1);
        saveBtn.setOnClickListener(new mClick());
        readBtn = (Button) findViewById(R.id.button3);
        readBtn.setOnClickListener(new mClick());
        savesdBtn = (Button) findViewById(R.id.button2);
        savesdBtn.setOnClickListener(new mClick());
        readsdBtn = (Button) findViewById(R.id.button4);
        readsdBtn.setOnClickListener(new mClick());

    }

    class mClick implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            if (arg0 == saveBtn) {
                savefile();
            } else if (arg0 == readBtn) {
                readfile(fileName);
            } else if (arg0 == savesdBtn) {
                saveSDcar();
            } else if (arg0 == readsdBtn) {
                readsdcard(fileName);
            }
        }
    }

    void savefile() {
        str = edit.getText().toString();
        FileUtils fileUtils=new FileUtils(FileReadTest.this,fileName);
        fileUtils.write(str);
    }

    void readfile(String fileName) {
        FileUtils fileUtils=new FileUtils(FileReadTest.this,fileName);
        String a=fileUtils.read();
        Log.d("main","-------------"+a);
    }

    //保存文件到SD卡
    void saveSDcar() {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }

        str = edit.getText().toString();
        FileUtils fileUtils=new FileUtils(FileReadTest.this,fileName);
        fileUtils.writeInSD(str);
//        if (Environment.getExternalStorageState()
//                .equals(Environment.MEDIA_MOUNTED)) {
//            File path = Environment.getExternalStorageDirectory();
//            File sdfile = new File(path, fileName);
//            try {
//                FileOutputStream f_out = new FileOutputStream(sdfile);
//                f_out.write(str.getBytes());
//                Toast.makeText(FileReadTest.this,
//                        "文件保存到SD卡", Toast.LENGTH_LONG).show();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    //从SD卡读取文件内容
    void readsdcard(String fileName) {
        FileUtils fileUtils=new FileUtils(FileReadTest.this,fileName);
        String a=fileUtils.readFromSD();
        Log.d("main","----------------------b="+a);
//        if (Environment.getExternalStorageState()
//                .equals(Environment.MEDIA_MOUNTED)) {
//            File path = Environment
//                    .getExternalStorageDirectory();
//            File sdfile = new File(path, fileName);
//            try {
//                FileInputStream in_file = new FileInputStream(sdfile);
//                byte[] buffer = new byte[1024];
//                int bytes = in_file.read(buffer);
//                str = new String(buffer, 0, bytes);
//                Toast.makeText(FileReadTest.this,
//                        "文件内容：" + str, Toast.LENGTH_LONG).show();
//            } catch (FileNotFoundException e) {
//                System.out.print("文件不存在");
//            } catch (IOException e) {
//                System.out.print("IO流错误");
//            }
//        }
    }



}
