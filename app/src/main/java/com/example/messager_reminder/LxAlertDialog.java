package com.example.messager_reminder;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类可以创建一个通知框
 * 使用步骤:1.初始化LxAlertDialog构造函数实例化一个对象
 *          2.(可选)设置对象的res属性为自定义的图标
 *          3.(可选)调用setBtnClickListener方法可设置确定或取消的单击事件
 *          4.若创建普通单行通知框:调用create方法;
 *            若创建多行普通列表通知框,调用createListAD方法
 *            若创建多行带单选项的列表通知框,调用createSingleChoiceListAD方法
 *            若创建多行带多选项的列表通知框,调用createMulChoiceListAD方法
 */
public class LxAlertDialog {

    //res:通知的图标,开放给外部更改
    public int res=0;
    //selectedIndex:单选框选中的索引
    public  int selectedIndex=0;
    //selectedIndex:多选框选中的索引集合
    public List<Integer> selectedIndexs=new ArrayList<Integer>();

    //context:上下文对象
    private Context context;
    //alertDialog:通知框对象
    public final AlertDialog.Builder builder ;
    //BUTTON_POSITIVE:确定按钮对应的值
    private static final int BUTTON_POSITIVE = -1;
    //BUTTON_NEGATIVE:取消按钮对应的值
    private static final int BUTTON_NEGATIVE  = -2;


    /**
     * LxAlertDialog构造函数
     * @param context:上下文对象
     */
    public LxAlertDialog(Context context) {
        this.context=context;
        builder = new AlertDialog.Builder(context);
//        alertDialog = new AlertDialog.Builder(context).create();
    }

    /**
     * create()方法用来创建提示框
     */
    public void  create( String title, String content){
        if(res!=0){
            builder.setIcon(res); //设置对话框的图标
        }
        builder.setTitle(title);      //设置对话框的标题
        builder.setMessage(content);    //设置要显示的内容
        builder.show(); //显示对话框

    }

    /**
     * setPostiveBtn用来设置提示框里确定的点击事件
     * @param btnWhich:若传入的值为-1,则改变确定按钮的单击事件,否则改变取消按钮的单击事件
     * @param btnTxt:确定按钮显示的文本
     * @param clickListener:确定的点击事件
     */
    public void setBtnClickListener(int btnWhich,String btnTxt,DialogInterface.OnClickListener clickListener){
        if(btnWhich==BUTTON_POSITIVE){
            builder.setPositiveButton(btnTxt, clickListener);
        }
        else {
            builder.setNegativeButton(btnTxt, clickListener);
        }

    }

    public void createListAD( String title,String[] items,DialogInterface.OnClickListener clickListener){

        if(res!=0){
            builder.setIcon(res); //设置对话框的图标
        }
        builder.setTitle(title);            //设置对话框的标题
        builder.setItems(items, clickListener);//添加列表项
        builder.create().show();  // 创建对话框并显示
    }

    public void createSingleChoiceListAD(String title,String[] items,DialogInterface.OnClickListener clickListener){
        if(res!=0){
            builder.setIcon(res); //设置对话框的图标
        }
        builder.setTitle(title);            //设置对话框的标题
        builder.setSingleChoiceItems(items, 0,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedIndex=which;
            }
        });
        builder.setPositiveButton("确定", clickListener);                            //添加确定按钮
        builder.create().show();  // 创建对话框并显示
    }

    public void createMulChoiceListAD(String title,String[] items,DialogInterface.OnClickListener clickListener){
        if (res != 0) {
            builder.setIcon(res); //设置对话框的图标
        }
        builder.setTitle(title);            //设置对话框的标题
        builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    selectedIndexs.add(which);
                } else {
                    if (selectedIndexs.contains(which)) {
                        selectedIndexs.remove(which);
                    }

                }
            }
        });
        builder.setPositiveButton("确定", clickListener);                            //添加确定按钮
        builder.create().show();  // 创建对话框并显示
    }

}
