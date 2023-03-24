package com.learning.roboticsprogram;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HistoryLeftFootFragment extends Fragment {
    History history;
    TextView dateView;
    TextView timeView;
    TextView reading1TextView;
    TextView reading2TextView;
    TextView reading3TextView;
    TextView reading4TextView;
    TextView statusTextView;
    ImageView reading1ImageView;
    ImageView reading2ImageView;
    ImageView reading3ImageView;
    ImageView reading4ImageView;
    ImageView statusImageView;
    TextView stepCntTextView;
    SeekBar readingSeekBar;
    private String date;
    private String time;
    private int status;
    private int stepCnt;
    private int stepGoal;
    private int numOfReadings;
    public HistoryLeftFootFragment(History hst){
        stepCnt = hst.getStepCnt();
        stepGoal = hst.getStepGoal();
        date = hst.getDate();
        time = hst.getTime();
        status = hst.getStatus_left();
        numOfReadings = hst.getNumOfReadings();
        history = hst;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return (ViewGroup) inflater.inflate(
                R.layout.history_info_layout_left, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        readingSeekBar = getView().findViewById(R.id.readingSeekBar);
        dateView = getView().findViewById(R.id.dateView);
        timeView = getView().findViewById(R.id.timeView);
        reading1TextView = getView().findViewById(R.id.readingView1);
        reading2TextView = getView().findViewById(R.id.readingView2);
        reading3TextView = getView().findViewById(R.id.readingView3);
        reading4TextView = getView().findViewById(R.id.readingView4);
        reading1ImageView = getView().findViewById(R.id.leftGradient1ImageView);
        reading2ImageView = getView().findViewById(R.id.leftGradient2ImageView);
        reading3ImageView = getView().findViewById(R.id.leftGradient3ImageView);
        reading4ImageView = getView().findViewById(R.id.leftGradient4ImageView);
        statusImageView = getView().findViewById(R.id.statusImageView);
        stepCntTextView = getView().findViewById(R.id.stepCntView);
        statusTextView = getView().findViewById(R.id.statusTextView);

        updateReadings(0);

        stepCntTextView.setText(stepCnt + " / " + stepGoal);
        timeView.setText(time);
        dateView.setText(date);

        if (status == 0){
            statusImageView.setBackgroundResource(R.drawable.green_status);
            statusTextView.setText(History.STATUS_TEXT[status]);
        }
        else if (status > 0){
            statusImageView.setBackgroundResource(R.drawable.green_status); //CHANGE TO RED
            statusTextView.setText(History.STATUS_TEXT[status]);
        }

        readingSeekBar.setProgress(2);
        readingSeekBar.setMax(numOfReadings-1);
        readingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateReadings(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
    private void updateReadings(int index){
        Pair<String, double[]> readingTmp = history.getLeftValuesByIndex(index);
        timeView.setText(readingTmp.first);
        double[] vals = readingTmp.second;
        reading1TextView.setText(Double.toString(vals[0]));
        reading1ImageView.setAlpha((int)(vals[0]/100.00*225.00));
        reading2TextView.setText(Double.toString(vals[1]));
        reading2ImageView.setAlpha((int)(vals[1]/100.00*225.00));
        reading3TextView.setText(Double.toString(vals[2]));
        reading3ImageView.setAlpha((int)(vals[2]/100.00*225.00));
        reading4TextView.setText(Double.toString(vals[3]));
        reading4ImageView.setAlpha((int)(vals[3]/100.00*225.00));
    }
}
