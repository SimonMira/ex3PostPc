package ex3PostPC;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.amir.ofir.ex3postpc.R;

import ex3PostPC.CounterTaskClasses.BaseCounterTask;

import java.io.Serializable;

class AsyncClassActivity extends AppCompatActivity {
    private static final String TAG_TASK_FRAGMENT = "Task Fragment";
    private BaseCounterTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_layout);

          // fragment init
        final FragmentManager fm = getSupportFragmentManager();

        if(fm.findFragmentByTag(TAG_TASK_FRAGMENT)==null){

            //task init
            Intent intent = getIntent();
            Serializable taskClassName = intent.getSerializableExtra("task");
            final Class taskClass = (Class) taskClassName;

            try {
                task = (BaseCounterTask) taskClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return;
            }
            //fargment start
            final AsyncClassFragment fragment = AsyncClassFragment.newInstance(getTask());
            fm.beginTransaction().add(R.id.empty_layout, fragment, TAG_TASK_FRAGMENT).commit();
        }


    }



    protected BaseCounterTask getTask(){
        return task;
    }


}
