package com.example.DataBaseUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteUtils extends SQLiteOpenHelper {
    /*
    变量区
     */
    Context ctx;
    static final String Database_name="PhoneBook.db";
    static final int Database_Version=1;
    SQLiteDatabase db;
    public int id_this;
    Cursor cursor;
    static  String TABLE_NAME="Users";
    static  String ID="_id";
    static  String USER_NAME="user_name";
    static  String ADDRESS="address";
    static  String TELEPHONE="telephone";
    static  String MAIl_ADDRESS="main_address";
    ContentValues values=new ContentValues();;
    /*
    构造函数
  */
    public SQLiteUtils(Context ctx)
    {
        super(ctx,Database_name,null,Database_Version);
        this.ctx=ctx;
    }
    /*
     实现抽象父类中的onCreate方法,用来创建数据库
      */
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE "+TABLE_NAME+" ("
                +ID+" INTEGER primary key autoincrement, "
                +USER_NAME+" text not null, "
                +TELEPHONE+" text not null, "
                +ADDRESS+" text not null, "
                +MAIl_ADDRESS+" text not null "+");";
        sqLiteDatabase.execSQL(sql);
    }

    /**
     *  getWritableDatabase创建和/或打开将用于读写的数据库。第一次调用它时，数据库将被打开onCreate，onUpgrade和/或onOpen将被调用。
     * @return
     */
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
    public void open(){
        db=ctx.openOrCreateDatabase("PhoneBook.db", Context.MODE_PRIVATE,null);
        /**
         * SQLiteDatabase对象的query方法:
         * 用途:查询数据
         * 使用:query方法有七个参数:
         * 1)表名  2)字段名,若为null,则为所有字段 3)查询条件
         * 4)参数数组,用来替换查询条件
         * 5)查询结果按指定字段分组
         * 6)限定分组的条件
         * 7)查询结果的排序条件
         */
        cursor=db.query("Users",null,null,null,null,null,null);
        cursor.moveToNext();
    }
    public void close(){
        cursor.close();
    }
    public void add(String colName,String value){
        values.put(colName,value);
        db.insert(TABLE_NAME,null,values);
        values.clear();
        db.close();

    }
    public void delete(String where){
        db.delete(TABLE_NAME,where,null);
        db.close();
    }
    public void update(String colName,String value,String where){
        values.put(colName,value);
        db.update(TABLE_NAME,values,where,null);
        values.clear();
        db.close();
    }
    public void search(){

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
