package ex3PostPC;//package com.amir.ofir.ex3postpc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ex3PostPC.CounterTaskClasses.AsyncTaskCounter;
import ex3PostPC.CounterTaskClasses.BaseCounterTask;
import ex3PostPC.CounterTaskClasses.ThreadTask;
import com.amir.ofir.ex3postpc.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start_activity(Class<? extends BaseCounterTask> taskToInit){
        Intent intent = new Intent(this,AsyncClassActivity.class);
        intent.putExtra("task",taskToInit);
        startActivity(intent);
    }

    public void threads_activity_button_clicked(View view) {
        start_activity(ThreadTask.class);
    }

    public void async_task_button_clicked(View view) {
        start_activity(AsyncTaskCounter.class);
    }
}
