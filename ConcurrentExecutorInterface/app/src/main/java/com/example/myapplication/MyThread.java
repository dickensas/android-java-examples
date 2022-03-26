package com.example.myapplication;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

class MyThread extends Thread implements Runnable {
    private boolean running=false;
    MyCallback cb;
    int count;
    AppCompatActivity context;
    MyThread(AppCompatActivity context, MyCallback cb, int count) {
        this.context = context;
        this.cb = cb;
        this.count = count;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while(running) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cb.callBack(count);
            }
        });
    }
}
