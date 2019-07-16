package com.example.graphicsAndMultimedia;

import android.content.Context;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * 用途:用来播放视频
 * 使用:1,在布局文件中添加
 *          <VideoView
 *             android:id="@+id/video"
 *           android:layout_width="320dp"
 *            android:layout_height="240dp" />
 *      2.调用VideoPlayUtil.getInstance方法初始化一个单例对象
 *      3.调用start方法可以开始播放
 */
public class VideoPlayUtil {
    private static VideoPlayUtil videoPlayUtil;
    Context context;
    String path;
    private static VideoView videoView;
    MediaController mediaController;
    private VideoPlayUtil(Context context, String path, VideoView videoView) {
        this.videoView = videoView;
        this.videoView.setVideoPath(path);
        this.mediaController = new MediaController(context);
        this.mediaController.setMediaPlayer(videoView);
        this.videoView.setMediaController(mediaController);
    }

    /**
     * 单例模式获取视频播放类
     * @return
     */
    public static VideoPlayUtil getInstance(Context context, String path, VideoView videoView){
        if (null == videoPlayUtil) {
            videoPlayUtil = new VideoPlayUtil(context,path,videoView);

        }
        return videoPlayUtil;
    }
    public static void start(){
        videoView.start();
    }
}
