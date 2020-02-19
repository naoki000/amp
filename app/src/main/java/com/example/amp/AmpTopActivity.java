package com.example.amp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AmpTopActivity extends BaseActivity
        implements View.OnClickListener {

    private RecordedAudioController mRecordedAudioController;
    private RecordController mRecordController;

    private ItemButton mRecordStart;
    private ItemButton mRecordEnd;
    private ItemButton mRecordPlay;
    private ItemButton mRecordStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amp_top_activity);
        mRecordedAudioController = new RecordedAudioController(this);
        mRecordController = new RecordController(this);

        mRecordStart = initializeButton(R.id.record_start, "Record Start");
        mRecordEnd = initializeButton(R.id.record_end, "Record End");
        mRecordPlay = initializeButton(R.id.record_play, "Record Play");
        mRecordStop = initializeButton(R.id.record_stop, "Record Stop");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch ((Integer) v.getTag()) {
            case R.id.record_start:
                mRecordController.startRecord();
                break;
            case R.id.record_end:
                mRecordController.stopRecord();
                break;
            case R.id.record_play:
                mRecordedAudioController.startPlay(mRecordController.getFiePath());
                break;
            case R.id.record_stop:
                mRecordedAudioController.stopPlay();
                break;
            default:
                break;
        }

    }
}
