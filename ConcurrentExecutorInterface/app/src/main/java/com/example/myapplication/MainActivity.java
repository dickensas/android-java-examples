package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements MyCallback {

    int uicount = 0;
    Executor ex;
    MyThread th;

    public void callBack(int count) {
        uicount = count;
        TextView tv = findViewById(R.id.textView);
        tv.setText(String.valueOf(uicount));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View view) {
        th = new MyThread(this, this, uicount);
        ex = Executors.newSingleThreadExecutor();
        th.setRunning(true);
        ex.execute(th);
    }

    public void onStopClick(View view) {
        if(th!=null) {
            th.setRunning(false);
        }
    }
}