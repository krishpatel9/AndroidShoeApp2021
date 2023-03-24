package com.learning.roboticsprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    RelativeLayout side_view_layout;
    RelativeLayout bottom_view_layout;
    RelativeLayout history_view_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        side_view_layout = findViewById(R.id.side_view_layout);
        bottom_view_layout = findViewById(R.id.bottom_view_layout);
        history_view_layout = findViewById(R.id.history_view_layout);

//        side_view_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), ShoeSideActivity.class);
//                startActivity(intent);
//            }
//        });

        bottom_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShoeBottomActivityLR.class);
                startActivity(intent);
            }
        });

        history_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.darkRed));
        getSupportActionBar().setTitle("Dashboard");
    }
}