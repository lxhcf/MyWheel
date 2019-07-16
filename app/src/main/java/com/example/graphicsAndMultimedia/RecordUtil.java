package com.example.graphicsAndMultimedia;

import android.media.MediaRecorder;

public class RecordUtil {
    MediaRecorder mRecorder;
    String path;
    public RecordUtil(String path) {
        this.path=path;
        mRecorder = new MediaRecorder();
    }
    public void start(){
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(
                MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setAudioEncoder(
                MediaRecorder.AudioEncoder.AMR_NB);
        mRecorder.setOutputFile(path);
        try {
            mRecorder.prepare();
        } catch (Exception e) {
            System.out.println("Recorder err ... ");
        }
        mRecorder.start();
    }
    public void pause(){
        //https://blog.csdn.net/yegongheng/article/details/40624267
        //没有提供暂停的方法,想暂停可参照以上链接
//        mRecorder.pause();
    }
    public void stop(){
        mRecorder.stop();   //停止录制
        mRecorder.reset();  //重置
        mRecorder.release();//释放播放器有关资源
    }

}
