package com.hyfun.preview;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.danikula.videocache.HttpProxyCacheServer;
import com.hyfun.preview.base.App;
import com.hyfun.preview.widget.JZMediaAliyun;
import com.hyfun.preview.widget.JZMediaExo;
import com.hyfun.preview.widget.SlideCloseLayout;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;


public class PreviewVideoActivity extends BaseActivity {

  private SlideCloseLayout slideCloseLayout;
  private JzvdStd jzvdStd;
  private LinearLayout topBakLin;
  private ImageView back;
  private String title = "";
  private String videoPath;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Util.setFullScreen(this);
    setContentView(R.layout.fun_activity_preview_video);
    //设置activity的背景为黑色
    getWindow().getDecorView().setBackgroundColor(Color.BLACK);
    initIntent();
    initView();
    initData();
  }

  private void initIntent() {
    Intent intent = getIntent();
    title = intent.getStringExtra(Const.VIDEO_TITLE);
    videoPath = intent.getStringExtra(Const.VIDEO_PATH);
    if (TextUtils.isEmpty(title)) title = "";
  }

  private void initView() {
    //slideCloseLayout = findViewById(R.id.preview_view_slide_view);
    jzvdStd = findViewById(R.id.jz_video);
    topBakLin = findViewById(R.id.linTop);
    back = findViewById(R.id.backBtn);
  }

  private void initData() {
    jzvdStd.setUp(videoPath, title);
    jzvdStd.setMediaInterface(JZMediaExo.class);
    jzvdStd.startPreloading();
    back.setOnClickListener(v-> finish());
  }


  @Override
  public void onBackPressed() {
    if (Jzvd.backPress()) {
      return;
    }
    super.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();
    Jzvd.releaseAllVideos();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
      // 横屏
      topBakLin.setVisibility(View.GONE);
    } else {
      topBakLin.setVisibility(View.VISIBLE);
    }
  }

}
