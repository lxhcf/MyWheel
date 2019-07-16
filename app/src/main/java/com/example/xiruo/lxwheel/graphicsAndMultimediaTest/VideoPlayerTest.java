package com.example.xiruo.lxwheel.graphicsAndMultimediaTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.graphicsAndMultimedia.VideoPlayUtil;
import com.example.xiruo.lxwheel.R;

public class VideoPlayerTest extends AppCompatActivity {
    private VideoView mVideoView;
   private Button playBtn;
   MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_test);
        mVideoView = new VideoView(this);
               mVideoView = (VideoView)findViewById(R.id.video);
//              mMediaController = new MediaController(this);
               playBtn = (Button)findViewById(R.id.playButton);
               playBtn.setOnClickListener(new mClick());
        String path="/sdcard/sample.3gp";
        VideoPlayUtil.getInstance(this,path,mVideoView);

    }
    class mClick implements View.OnClickListener
	{
       		@Override
       		public void onClick(View v)
       		{
            			VideoPlayUtil.start();
//            		 	mVideoView.setVideoPath(path);
//           		 	mMediaController.setMediaPlayer(mVideoView);
//           		    mVideoView.setMediaController(mMediaController);
//           			mVideoView.start();
            	}
        	}

}
