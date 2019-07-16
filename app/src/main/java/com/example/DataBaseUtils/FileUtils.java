package com.example.DataBaseUtils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用途:FileUtils是用来读写字符串存放到一个文本文件 ;该文本文件可以存到本地资源文件夹中,也可以存到sd卡上.
 * 使用:1.使用构造函数初始化一个对象
 *      2.调用write方法可以实现写数据到文件中,如果想将文件存到sd卡上就调用writeInSD方法
 *      3.调用read方法可以实现从文件中读数据,如果想读sd卡上的文件就调用readFromSD方法
 */
public class FileUtils {
    Context context;
    String fileName;
    public FileUtils(Context context, String fileName) {
        this.context=context;
        this.fileName=fileName;
    }

    public  void write( String content){
        try {
            FileOutputStream fos =
                    context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void writeInSD( String content){
        if (Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)) {
            File path = Environment.getExternalStorageDirectory();
            File sdFile = new File(path, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(sdFile);
                fos.write(content.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String read() {
        String str = null;
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(fileName);
//            int len;
//            while ((len=fis.read(buffer))!=-1){
//                sb.append(buffer);
//            }
            int bytes = fis.read(buffer);
            str = new String(buffer, 0, bytes).toString();
            return str;
        } catch (FileNotFoundException e) {
            System.out.print("文件不存在");
        } catch (IOException e) {
            System.out.print("IO流错误");
        }
        return str;
    }

    public String readFromSD() {
        String str = null;
        if (Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)) {
            File path = Environment
                    .getExternalStorageDirectory();
            File sdFile = new File(path, fileName);
            try {
                FileInputStream fis = new FileInputStream(sdFile);
                byte[] buffer = new byte[1024];
                int bytes = fis.read(buffer);
                str=new String(buffer, 0, bytes);
                return str;
            } catch (FileNotFoundException e) {
                System.out.print("文件不存在");
            } catch (IOException e) {
                System.out.print("IO流错误");
            }
        }
        return str;
    }

}
