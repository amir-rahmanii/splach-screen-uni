package com.example.splashactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spalsh_activity);
        splashWithThread();
    }

    private void splashWithThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }


}
