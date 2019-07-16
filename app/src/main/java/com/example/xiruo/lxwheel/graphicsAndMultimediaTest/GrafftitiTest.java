package com.example.xiruo.lxwheel.graphicsAndMultimediaTest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.graphicsAndMultimedia.Grafftiti;
import com.example.xiruo.lxwheel.R;

public class GrafftitiTest extends Activity {
    private Grafftiti handWrite = null;
    private Button clear = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("main","0--------------------------");

        setContentView(R.layout.activity_grafftiti_test);
        Log.d("main","1--------------------------");
        handWrite = (Grafftiti) findViewById(R.id.handwriteview);
        clear = (Button) findViewById(R.id.clear);
        Log.d("main","2--------------------------");

        clear.setOnClickListener(new mClick());

    }

    private class mClick implements View.OnClickListener {
        public void onClick(View v) {
            handWrite.clear();
        }
    }

}
