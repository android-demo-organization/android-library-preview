package com.hyfun.preview.demo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.hyfun.preview.FunPreview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void previewImage(View view) {
        List images = new ArrayList<>();
        images.add("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
        images.add("https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg");
        images.add("https://i.loli.net/2021/04/14/nNly8EdXJ2aHYTe.jpg");
        images.add(R.mipmap.big_width);
        FunPreview.previewImage(this, 0, images, false);
    }

    public void previewVideo(View view) {

        FunPreview.previewVideo(this, "", "https://cdn.gda.top/files/otc/1731566124989a.mp4");
    }


    public void previewAudio(View view) {
//        FunPreview.previewAudio(this, "我的名字", "http://cdn1.100rd.com/o_1cggnu8insukcnu18lt6rcegpf2.mp3");
    }
}
