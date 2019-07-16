package com.example.xiruo.lxwheel.DBTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.DataBaseUtils.SQLiteUtils;
import com.example.xiruo.lxwheel.R;

public class DBTestActivity extends AppCompatActivity implements View.OnClickListener{
    public Button btnBDB,btnODB,btnP,btnN,btnAdd,btnUpdate,btnDelete,btnClose;
    public  static  EditText etxtName,etxtTel,etxtAddress,etxtEmail;
    SQLiteUtils sqLiteUtils;
    Cursor cursor;
    Bundle savedInstanceState;
    int id_this;
    static  String TABLE_NAME="Users";
    static  String ID="_id";
    static  String USER_NAME="user_name";
    static  String ADDRESS="address";
    static  String TELEPHONE="telephone";
    static  String MAIl_ADDRESS="main_address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
        initView();
    }
    void initView() {
        btnBDB=(Button) this.findViewById(R.id.btnBDB);
        btnODB=(Button) this.findViewById(R.id.btnODB);
        btnP=(Button) this.findViewById(R.id.btnP);
        btnN=(Button) this.findViewById(R.id.btnN);
        btnAdd=(Button) this.findViewById(R.id.btnAdd);
        btnUpdate=(Button) this.findViewById(R.id.btnUpdate);
        btnDelete=(Button) this.findViewById(R.id.btnDelete);
        btnClose=(Button) this.findViewById(R.id.btnClose);
        etxtName = (EditText) findViewById(R.id.etxtName);
        etxtTel = (EditText) findViewById(R.id.etxtTel);
        etxtAddress = (EditText) findViewById(R.id.etxtAddress);
        etxtEmail = (EditText) findViewById(R.id.etxtEmail);
        btnBDB.setOnClickListener(this);
        btnODB.setOnClickListener(this);
        btnP.setOnClickListener(this);
        btnN.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBDB: //建立数据库
                sqLiteUtils =new SQLiteUtils(DBTestActivity.this);
                SQLiteDatabase db= sqLiteUtils.getWritableDatabase();
                break;
            case R.id.btnODB: //打开数据库
                //Context类的openOrCreateDatabase用来创建数据库或打开数据库
                // 每个程序都有自己的数据库
                // 通过openOrCreateDatabase来打开或创建一个数据库,返回SQLiteDatabase对象
                db=openOrCreateDatabase("PhoneBook.db", Context.MODE_PRIVATE,null);
                //有疑惑
                cursor=db.query("Users",null,null,null,null,null,null);
                cursor.moveToNext();
                btnP.setClickable(true);
                btnN.setClickable(true);
                btnDelete.setClickable(true);
                btnUpdate.setClickable(true);
                break;
            case R.id.btnP: //上一条
                if(!cursor.isFirst())
                    cursor.moveToPrevious();
                datashow();
                break;
            case R.id.btnN: //下一条
                if(!cursor.isLast())
                    cursor.moveToNext();
                datashow();
                break;
            case R.id.btnAdd: //添加
                add();
                //这里不太懂
                onCreate(savedInstanceState);
                datashow();
                break;
            case R.id.btnUpdate: //修改记录
                update();
                break;
            case R.id.btnDelete://删除一行
                delete();
                break;
            case R.id.btnClose://关闭数据库
                cursor.close();
                String str="数据库已关闭";
                etxtName.setText(str);
                etxtTel.setText(str);
                etxtAddress.setText(str);
                etxtEmail.setText(str);
                break;
            default:

                break;
        }

    }

    private void delete() {
        String where1=ID+"="+id_this;
        SQLiteDatabase db1= sqLiteUtils.getWritableDatabase();
        db1.delete(TABLE_NAME,where1,null);
        db1.close();
    }

    private void update() {
        ContentValues values1=new ContentValues();
        values1.put(USER_NAME,DBTestActivity.etxtName.getText().toString());
        values1.put(TELEPHONE,DBTestActivity.etxtTel.getText().toString());
        values1.put(ADDRESS,DBTestActivity.etxtAddress.getText().toString());
        values1.put(MAIl_ADDRESS,DBTestActivity.etxtEmail .getText().toString());
        String where1=ID+"="+id_this;
        SQLiteDatabase db1= sqLiteUtils.getWritableDatabase();
        db1.update(TABLE_NAME,values1,where1,null);
        db1.close();
    }

    private void add() {
        ContentValues values1=new ContentValues();
        values1.put(USER_NAME,DBTestActivity.etxtName.getText().toString());
        values1.put(TELEPHONE,DBTestActivity.etxtTel.getText().toString());
        values1.put(ADDRESS,DBTestActivity.etxtAddress.getText().toString());
        values1.put(MAIl_ADDRESS,DBTestActivity.etxtEmail .getText().toString());
        SQLiteDatabase db2= sqLiteUtils.getWritableDatabase();
        db2.insert(TABLE_NAME,null,values1);
        db2.close();
    }

    private void datashow() {
        id_this=Integer.parseInt(cursor.getString(0));
        String user_name_this=cursor.getString(1);
        String tel_this=cursor.getString(2);
        String ads_this=cursor.getString(3);
        String email=cursor.getString(4);
        etxtName.setText(user_name_this);
        etxtTel.setText(tel_this);
        etxtAddress.setText(ads_this);
        etxtEmail.setText(email);

    }
}
