package com.example.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.study.statusbar.StatusBarDemoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        Button mBtnMain = findViewById(R.id.btn_main);
        mBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DemoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button mBtnStatusBar = findViewById(R.id.btn_status_bar);
        mBtnStatusBar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatusBarDemoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
