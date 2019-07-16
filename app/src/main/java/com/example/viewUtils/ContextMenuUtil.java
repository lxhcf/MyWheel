package com.example.viewUtils;

import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuInflater;

import com.example.xiruo.lxwheel.R;

/**
 * 用途:用来生成一个上下文菜单
 * 使用:
 * 1. 在activity为文本框(其他组件亦可)注册上下文菜单
 *     registerForContextMenu(introduce);
 * 2.在activity重写onCreateContextMenu方法,在其中调用该类静态方法ContextMenuUtil.creatCtxtMenu(this,menu);
 * 3.在activity重写onContextItemSelected方法,在其中指定当点击了上下文菜单触发的操作
 */
public class ContextMenuUtil {
    public ContextMenuUtil() {
    }
    public static void creatCtxtMenu(Context context, ContextMenu menu){
        MenuInflater inflater = new MenuInflater(context); //实例化一个MenuInflater对象
        inflater.inflate(R.menu.introduce_menu, menu);    //解析菜单文件
    }
}
