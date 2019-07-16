package com.example.xiruo.lxwheel.graphicsAndMultimediaTest;

import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graphicsAndMultimedia.RecordUtil;
import com.example.xiruo.lxwheel.R;

public class RecordTest extends AppCompatActivity {
    MediaRecorder mRecorder;
    String path;
    RecordUtil recordUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_test);
        //保存的路径
        path = "/sdcard/audio.amr";
        Button button= (Button) findViewById(R.id.btnRecord);//获取布局文件中的广播按钮
        Button button2= (Button) findViewById(R.id.btnStop);//获取布局文件中的广播按钮
        recordUtil=new RecordUtil(path);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startRecordAudio(path);
                recordUtil.start();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                stopRecord();
                recordUtil.stop();
            }
        });

    }

    void startRecordAudio(String path) {
        mRecorder = new MediaRecorder();
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

    void stopRecord() {
        mRecorder.stop();   //停止录制
        mRecorder.reset();  //重置
        mRecorder.release();//释放播放器有关资源
    }


}
