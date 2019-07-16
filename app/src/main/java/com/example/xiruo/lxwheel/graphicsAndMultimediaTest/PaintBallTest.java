package com.example.xiruo.lxwheel.graphicsAndMultimediaTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.graphicsAndMultimedia.PainBallUtils;
import com.example.xiruo.lxwheel.R;

public class PaintBallTest extends AppCompatActivity {
    int x1=150,y1=50;
    PainBallUtils painBallUtils;
    Button btn;
  EditText edit_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_ball_test);
        painBallUtils = (PainBallUtils) findViewById(R.id.testView1);
        painBallUtils.setXY(x1, y1);
        btn = (Button) findViewById(R.id.button1);
        edit_y = (EditText) findViewById(R.id.editText1);
        btn.setOnClickListener(new mClick());

    }

    class mClick implements View.OnClickListener {
        @Override
        public void onClick(View arg0) {
            y1 = Integer.parseInt(edit_y.getText().toString());
            painBallUtils.setXY(x1, y1);
            painBallUtils.invalidate();
        }
    }

}
