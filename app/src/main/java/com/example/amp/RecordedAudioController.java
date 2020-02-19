package com.example.amp;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class RecordedAudioController {

    private static String TAG = RecordedAudioController.class.getSimpleName();

    private MediaPlayer mp;
    private Context mContext;

    RecordedAudioController(Context context) {
        mContext = context;
    }

    // 再生
    public void startPlay(int startAudioId) {
        Log.e(TAG,"startPlay");

        mp = MediaPlayer.create(mContext,  startAudioId);
        try {
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startPlay(String filePath) {
        Log.e(TAG,"startPlay");

        try {
            mp = new MediaPlayer();
            mp.setDataSource(filePath);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 停止
    public void stopPlay() {
        Log.e(TAG,"stopPlay");

        try {
            mp.stop();
            mp.prepare();
            mp.release();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
