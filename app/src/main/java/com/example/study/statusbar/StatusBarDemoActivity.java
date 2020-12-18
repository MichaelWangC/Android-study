package com.example.study.statusbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.study.R;
import com.example.study.base.BaseActivity;
import com.example.study.statusbar.util.StatusBarUtil;

public class StatusBarDemoActivity extends BaseActivity {

    private ViewGroup contentLayout;

    private CheckBox mChbTranslucent;

    private TextView mTvStatusAlpha;
    private SeekBar mSbChangeAlpha;

    private Button mBtSetColor;

    private int mAlpha = 112; // 默认值

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);

        initView();
    }

    private void initView() {
        contentLayout = findViewById(R.id.container);

        mChbTranslucent = findViewById(R.id.chb_translucent);

        mChbTranslucent.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    contentLayout.setBackgroundColor(Color.CYAN);
                    StatusBarUtil.setTransparent(StatusBarDemoActivity.this);
                } else {
                    contentLayout.setBackgroundColor(Color.WHITE);
                    StatusBarUtil.setColor(StatusBarDemoActivity.this, getResources().getColor(R.color.colorPrimaryDark), mAlpha);
                }
            }
        });

        mTvStatusAlpha = findViewById(R.id.tv_status_alpha);
        // 状态栏透明度 设置控件
        mSbChangeAlpha = findViewById(R.id.sb_change_alpha);
        mSbChangeAlpha.setMax(255);
        mSbChangeAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAlpha = progress;
                mTvStatusAlpha.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSbChangeAlpha.setProgress(mAlpha); // 默认值设置

        /// 设置导航栏颜色
        mBtSetColor = findViewById(R.id.bt_setColor);
        mBtSetColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StatusBarUtil.setColor(StatusBarDemoActivity.this, Color.GREEN, mAlpha);
            }
        });
    }
}
