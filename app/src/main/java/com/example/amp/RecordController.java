package com.example.amp;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;


import java.io.File;

public class RecordController {

    private static String TAG = RecordController.class.getSimpleName();

    private Context mContext;
    private MediaRecorder rec;
    /* 録音先のパス */
    private String filePath;

    RecordController(Context context) {
        mContext = context;
//        filePath = mContext.getFilesDir().getPath() + "/sample.wav"; //なぜかerrorが発生
        filePath = Environment.getExternalStorageDirectory() + "/Android/data/com.example.amp/sample.wav";
        Log.e("test", filePath);
    }

    public void startRecord() {
        Log.e(TAG,"startRecord");
        /* ファイルが存在する場合は削除 */
        File wavFile = new File(filePath);
        if (wavFile.exists()) {
            wavFile.delete();
        }
        wavFile = null;

        try {
            rec = new MediaRecorder();
            rec.setAudioSource(MediaRecorder.AudioSource.MIC);
            rec.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
            rec.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            rec.setOutputFile(filePath);

            rec.setMaxFileSize(0);
            rec.prepare();
            rec.start();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void stopRecord() {
        Log.e(TAG,"stopRecord");
        try {
            rec.stop();
            rec.reset();
            rec.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String  getFiePath() {
        return filePath;
    }
}
