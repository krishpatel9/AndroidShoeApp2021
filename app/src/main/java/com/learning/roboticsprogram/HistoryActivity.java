package com.learning.roboticsprogram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    public static final String TAG = "HistoryActivity";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("M/d/yyyy");
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm:ss a");

    HistoryFragment historyFragment;
    List<History> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity_layout);

        historyList = new ArrayList<>();
        History hst1 = new History(dateFormatter.format(new Date()), timeFormatter.format(new Date()), 7500, 10000);

        hst1.addReadings(timeFormatter.format(new Date()), new double[]{20,40,60,100,20,40,60,100});
        ArrayList<double[]> dblList = new ArrayList<double[]>();
        dblList.add(new double[]{20,40,60,100,20,40,60,100});
        for(int i = 1; i < 100; i++){
            double[] tmpArr = new double[8];
            for (int k = 0; k < tmpArr.length; k++){
                double oldVal = dblList.get(i-1)[k];
                if (oldVal > 95.00){
                    tmpArr[k] = oldVal - (int)(Math.random()*(10+1)-(0));
                }
                else if (oldVal < 20.00){
                    tmpArr[k] = oldVal + (int)(Math.random()*(10+1)-(0));
                }
                else{
                    if((Math.random() < 0.5)){
                        tmpArr[k] = oldVal + (int)(Math.random()*(5+1)-(0));
                    }
                    else{
                        tmpArr[k] = oldVal - (int)(Math.random()*(5+1)-(0));
                    }
                }
            }
            dblList.add(tmpArr);
        }
        for (int i = 0; i < 100; i++){
            hst1.addReadings(timeFormatter.format(new Date()), new double[]{95,90,40,30,85,95,35,45});
        }
//        for(int i = 0; i < 5; i++){
//            hst1.addReadings(timeFormatter.format(new Date()), new double[]{20,40,60,100,20,40,60,100});
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        hst1.setStatus(History.STATUS_GOOD, History.STATUS_GOOD);
        historyList.add(hst1);
//        historyList.add(new History("4/3/2021", "4:46 PM", 0, 10000));
//        historyList.add(new History("4/5/2021", "4:47 PM", 0, 10000));
//        historyList.add(new History("4/6/2021", "4:48 PM", 3000, 10000));
//        historyList.add(new History("4/7/2021", "4:49 PM", 5000, 10000));
//        historyList.add(new History("4/8/2021", "4:50 PM", 6000, 10000));
//        historyList.add(new History("4/9/2021", "4:52 PM", 8000, 10000));
//        historyList.add(new History("4/10/2021", "4:59 PM", 9500, 10000));

        historyFragment = new HistoryFragment(this, historyList);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.recyclerListContainer, historyFragment)
                .commit();


        getWindow().setStatusBarColor(ContextCompat.getColor(HistoryActivity.this, R.color.darkRed));
        getSupportActionBar().setTitle("History");
    }
}