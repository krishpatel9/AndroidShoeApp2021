package com.learning.roboticsprogram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class LeftFootFragment extends Fragment{
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
    double[] vals;
    private int status;
//    public LeftFootFragment(double[] vals, int status){
//        this.status = status;
//        this.vals = vals;
//    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return (ViewGroup) inflater.inflate(
                R.layout.shoe_back_activity_left, container, false);
    }
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        reading1TextView = getView().findViewById(R.id.reading1_L);
//        reading2TextView = getView().findViewById(R.id.reading2_L);
//        reading3TextView = getView().findViewById(R.id.reading3_L);
//        reading4TextView = getView().findViewById(R.id.reading4_L);
////        reading1ImageView
//    }
}
