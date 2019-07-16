package com.example.xiruo.lxwheel.graphicsAndMultimediaTest;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.graphicsAndMultimedia.MusicPlayUtils;
import com.example.xiruo.lxwheel.R;

import java.io.IOException;

public class MusicPlayerTest extends AppCompatActivity {
    CheckBox ch1, ch2;
    TextView txt;
    ImageButton mStopButton, mStartButton, mPauseButton;
    MediaPlayer mMediaPlayer;
    String sdcard_file;
    int res_file;
    MusicPlayUtils musicPlayUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player_test);
        sdcard_file = new String("/sdcard/music/mtest2.mp3");
        res_file = R.raw.mtest2;
        mMediaPlayer = new MediaPlayer();
        ch1 = (CheckBox) findViewById(R.id.check1);
        ch2 = (CheckBox) findViewById(R.id.check2);
        txt = (TextView) findViewById(R.id.text1);
        mStopButton = (ImageButton) findViewById(R.id.Stop);
        mStartButton = (ImageButton) findViewById(R.id.Start);
        mPauseButton = (ImageButton) findViewById(R.id.Pause);
        mStopButton.setOnClickListener(new mStopClick());
        mStartButton.setOnClickListener(new mStartClick());
        mPauseButton.setOnClickListener(new mPauseClick());

    }

    private void playMusic(String path) {
        try {
            /* 重置MediaPlayer对象，使之处于空闲状态 */
            mMediaPlayer.reset();
            /* 设置要播放的文件的路径 */
            mMediaPlayer.setDataSource(path);
            /* 准备播放 */
            mMediaPlayer.prepare();
            /* 开始播放 */
            mMediaPlayer.start();
        } catch (IOException e) {
        }
    }

    /* 停止按钮事件  */
    class mStopClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            /* 是否正在播放 */
//            if (mMediaPlayer.isPlaying()) {
//                //重置MediaPlayer到初始状态
//                mMediaPlayer.reset();
//                mMediaPlayer.release();
//            }
            musicPlayUtils.stop();

        }
    }

    /* 播放按钮事件  */
    class mStartClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String str = "";
            if (ch1.isChecked()) {
                musicPlayUtils=new MusicPlayUtils(MusicPlayerTest.this,res_file);
                musicPlayUtils.play();
//                MusicPlayUtils.
//                str = str + "\n" + ch1.getText();
//                try {
//                    mMediaPlayer = MediaPlayer.create(MusicPlayerTest.this, res_file);
//                    mMediaPlayer.start();
//                } catch (Exception e) {
//                    Log.i("ch1", "res err ....");
//                }
            }
            if (ch2.isChecked()) {
                musicPlayUtils=new MusicPlayUtils(sdcard_file);
                musicPlayUtils.play();
//                str = str + "\n" + ch2.getText();
//                try {
//                    mMediaPlayer = new MediaPlayer();
//                    mMediaPlayer.setDataSource(sdcard_file);
//                    playMusic(sdcard_file);
//                } catch (Exception e) {
//                    Log.i("ch2", "sdcard err .... ");
//                }
            }
//            txt.setText(str);
        }
    }

    /* 暂停按钮事件  */
    class mPauseClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            if (mMediaPlayer.isPlaying()) {
//                /* 暂停 */
//                mMediaPlayer.pause();
//            } else {
//                /* 开始播放 */
//                mMediaPlayer.start();
//            }
            musicPlayUtils.pause();
        }
    }


}
