package com.hyfun.preview;

import android.content.Context;
import android.content.Intent;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FunPreview {


    /**
     * @param context
     * @param imagePath
     * @param isLocal
     */
    public static final void previewImage(Context context, Object imagePath, boolean isLocal) {
        List list = new ArrayList();
        list.add(imagePath);
        previewImage(context, 0, list, isLocal);
    }

    /**
     * @param context
     * @param position
     * @param imageList
     */
    public static final void previewImage(Context context, int position, List imageList, boolean isLocal) {
        Intent intent = new Intent(context, PreviewImageActivity.class);
        intent.putExtra(Const.IMAGE_POSITION, position);
        intent.putExtra(Const.IMAGE_LIST, (Serializable) imageList);
        intent.putExtra(Const.IMAGE_IS_LOCAL, isLocal);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.fun_preview_activity_up_in, 0);
        ActivityCompat.startActivity(context, intent, compat.toBundle());
    }


    /**
     * @param context
     * @param path
     */
    public static final void previewVideo(Context context, String path) {
        Intent intent = new Intent(context, PreviewVideoActivity.class);
        intent.putExtra(Const.VIDEO_PATH, path);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.fun_preview_activity_up_in, 0);
        ActivityCompat.startActivity(context, intent, compat.toBundle());
    }

    /**
     * @param context
     * @param title
     * @param path
     */
    public static final void previewVideo(Context context, String title, String path) {
        Intent intent = new Intent(context, PreviewVideoActivity.class);
        intent.putExtra(Const.VIDEO_TITLE, title);
        intent.putExtra(Const.VIDEO_PATH, path);
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.fun_preview_activity_up_in, 0);
        ActivityCompat.startActivity(context, intent, compat.toBundle());
    }


    /**
     * @param context
     * @param title
     * @param path
     */
//    public static final void previewAudio(Context context, String title, String path) {
//        Intent intent = new Intent(context, PreviewAudioActivity.class);
//        intent.putExtra(Const.AUDIO_TITLE, title);
//        intent.putExtra(Const.AUDIO_PATH, path);
//        ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(context, R.anim.fun_preview_activity_up_in, 0);
//        ActivityCompat.startActivity(context, intent, compat.toBundle());
//    }
}
