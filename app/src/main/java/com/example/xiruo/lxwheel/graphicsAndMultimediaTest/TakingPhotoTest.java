package com.example.xiruo.lxwheel.graphicsAndMultimediaTest;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xiruo.lxwheel.R;

public class TakingPhotoTest extends AppCompatActivity implements View.OnClickListener {
    private Button takePhotoBtn,pickPhotoBtn,cancelBtn;
    private Uri photoUri;
    private String picPath;
    public static final int TAKE_PHOTO = 1;
    /***
     * 使用相册中的图片
     */
    public static final int PICK_PHOTO = 2;
    /***
     * 从Intent获取图片路径的KEY
     */
    public static final String KEY_PHOTO_PATH = "photo_path";
    /***
     * 使用照相机拍照获取图片 这个参数有点像是标识activities的id
     */
    private Intent lastIntent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_photo_test);
        initView();

    }
    private void initView() {
        takePhotoBtn = (Button) findViewById(R.id.btn_take_photo);
        takePhotoBtn.setOnClickListener(this);
        pickPhotoBtn = (Button) findViewById(R.id.btn_pick_photo);
        pickPhotoBtn.setOnClickListener(this);
        cancelBtn = (Button) findViewById(R.id.btn_cancel);
        cancelBtn.setOnClickListener(this);
        lastIntent = getIntent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_layout:
                finish();
                break;
            case R.id.btn_take_photo:
                takePhoto();
                break;
            case R.id.btn_pick_photo:
                pickPhoto();
                break;
            default:
                finish();
                break;
        }
    }

    /**
     * 拍照步骤:
     * 1.判断权限是否开启
     * 2.判断SD卡是否存在(照片存到sd卡中)
     * 3.新建一个URL对象用来存放照片地址
     * 4.新建一个intent调用系统相机,同时想intent里存照片地址对象,当拍完照,系统默认把相片对象放到这个路径下
     * 5.调用startActivityForResult,启动intent对象,系统会默认返回路径对象
     * 6.不用在onActivityResult中调用photoUri = data.getData();因为拍照模式路径恒定,反之选照片路径不定需要找
     */
    private void takePhoto() {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.CAMERA};
            //验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                    return;
                }
            }
        }
        //执行拍照前，应该先判断SD卡是否存在
        String SDState = Environment.getExternalStorageState();
        if(SDState.equals(Environment.MEDIA_MOUNTED))
        {
            //this.getContentResolver())返回的当然是ContentResolver,ContentResolver负责获取ContentProvider提供的数据
            //设置系统相机拍摄照片完成后图片文件的存放地址
            // ContentProvider可以提供数据在进程之间共享。
            photoUri = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//"android.media.action.IMAGE_CAPTURE"
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, TAKE_PHOTO);
        }else{
            Toast.makeText(this,"内存卡不存在", Toast.LENGTH_LONG).show();
        }
    }

    private void pickPhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_PHOTO);
    }
    /**
     * 选择图片后，获取图片的路径
     * @param requestCode
     * @param data
     */
    private void doPhoto(int requestCode,Intent data)
    {
        /**
         * 若是从相册取图片,需要获取路径
         */
        if(requestCode == PICK_PHOTO)  //从相册取图片，有些手机有异常情况，请注意
        {
            if(data == null)
            {
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }

            photoUri = data.getData();

            if(photoUri == null )
            {
                Toast.makeText(this, "选择图片文件出错", Toast.LENGTH_LONG).show();
                return;
            }
        }
        /**
         * 通过照片的路径,从相册中获取照片的名称
         * photoUri----picPath
         */
        String[] pojo = {MediaStore.Images.Media.DATA};//MediaStore.Images.Media.DATA,字符串类型；Path to the media item on disk
        Cursor cursor = managedQuery(photoUri, pojo, null, null,null);//定义一个游标用来查询照片
        if(cursor != null )
        {
            int columnIndex = cursor.getColumnIndexOrThrow(pojo[0]);
            cursor.moveToFirst();
            picPath = cursor.getString(columnIndex);
            cursor.close();
        }
        /**
         * 向前一个activity返回数据
         */
        if (picPath != null && (picPath.endsWith(".png") || picPath.endsWith(".PNG") || picPath.endsWith(".jpg") || picPath.endsWith(".JPG"))) {
            lastIntent.putExtra(KEY_PHOTO_PATH, picPath);
            setResult(TakingPhotoTest.RESULT_OK, lastIntent);
            finish();
        } else {
            Toast.makeText(this, "选择图片文件不正确", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == TakingPhotoTest.RESULT_OK)
        {
            doPhoto(requestCode,data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
