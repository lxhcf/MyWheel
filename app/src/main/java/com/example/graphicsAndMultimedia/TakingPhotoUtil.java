package com.example.graphicsAndMultimedia;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.net.URL;

public class TakingPhotoUtil {
    public static void takingPhoto(Context context){

//        if (Build.VERSION.SDK_INT >= 23) {
//            int REQUEST_CODE_CONTACT = 101;
//            String[] permissions = {Manifest.permission.CAMERA};
//            //验证是否许可权限
//            for (String str : permissions) {
//                if (context.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
//                    //申请权限
//                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
//                    return;
//                }
//            }
//        }

//        //执行拍照前，应该先判断SD卡是否存在
//        String SDState = Environment.getExternalStorageState();
//        if(SDState.equals(Environment.MEDIA_MOUNTED))
//        {
//
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//"android.media.action.IMAGE_CAPTURE"
//            /***
//             * 需要说明一下，以下操作使用照相机拍照，拍照后的图片会存放在相册中的
//             * 这里使用的这种方式有一个好处就是获取的图片是拍照后的原图
//             * 如果不实用ContentValues存放照片路径的话，拍照后获取的图片为缩略图不清晰
//             */
//            ContentValues values = new ContentValues();
//            //this.getContentResolver())返回的当然是ContentResolver,
//            // ContentResolver负责获取ContentProvider提供的数据
//            Uri photoUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
//            //设置系统相机拍摄照片完成后图片文件的存放地址
//            // ContentProvider可以提供数据在进程之间共享。
//            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, photoUri);
            /**-----------------*/
//            startActivityForResult(intent, TAKE_PHOTO);
//        }
    }
}
