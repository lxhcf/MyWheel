package com.example.graphicsAndMultimedia;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * 用途:可以播放或暂停音乐
 * 使用:1.初始化一个对象
 *      2.调用play可以开始播放,调用pause可以暂停,调用stop可以停止
 */
public class MusicPlayUtils {
    String path;
    int res;
    MediaPlayer mMediaPlayer;
    Context context;
    /**
     * 单例模式获取上传工具类
     * @return
     */
    public MusicPlayUtils (String path) {
        this.path=new String(path);;
        mMediaPlayer = new MediaPlayer();
    }
    public  MusicPlayUtils (Context context,int res) {
        this.res=res;
        this.context=context;
        mMediaPlayer = MediaPlayer.create(context, res);
    }
    public void play(){
        if(mMediaPlayer!=null ){
            mMediaPlayer.start();
        }
        else{
            if (path == null) {
                try {
                    mMediaPlayer.start();
                } catch (Exception e) {
                }
            }
            else {
                try {
                    /* 重置MediaPlayer对象，使之处于空闲状态 */
                    mMediaPlayer.reset();
                    /* 设置要播放的文件的路径 */
                    mMediaPlayer.setDataSource(path);
                    /* 准备播放 */
                    mMediaPlayer.prepare();
                    /* 开始播放 */
                    mMediaPlayer.start();
                } catch (Exception e) {
                }
            }
        }



    }

    public void pause(){
        mMediaPlayer.pause();
    }

    public void stop(){
        if(mMediaPlayer!=null && mMediaPlayer.isPlaying())
        {
            //重置MediaPlayer到初始状态
            mMediaPlayer.reset();
            mMediaPlayer.release();
        }

    }


}
