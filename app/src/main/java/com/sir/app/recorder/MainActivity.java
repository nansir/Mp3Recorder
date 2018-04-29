package com.sir.app.recorder;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.czt.mp3recorder.MP3Recorder;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button reorderBtn;
    MP3Recorder mRecorder;

    String reorderPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reorderPath = Environment.getExternalStorageDirectory().getPath() + "/5566.mp3";
        mRecorder = new MP3Recorder(new File(reorderPath));
        reorderBtn = findViewById(R.id.start_reorder);
        reorderBtn.setOnClickListener(this);

        Log.i("TAG", reorderPath);
    }

    @Override
    public void onClick(View view) {
        try {
            if (mRecorder.isRecording()) {
                mRecorder.stop();
                reorderBtn.setText("开始录音");
            } else {
                mRecorder.start();
                reorderBtn.setText("结束录音");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
