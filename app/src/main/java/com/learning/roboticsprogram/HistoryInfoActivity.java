package com.learning.roboticsprogram;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import static com.learning.roboticsprogram.ShoeAppConstants.SERIALIZABLE_HISTORY;

public class HistoryInfoActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 2;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

//    SeekBar stepSeekBar;
    History history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_info_layout);

//        stepSeekBar = findViewById(R.id.stepSeekBar);

        history = (History) getIntent().getSerializableExtra(SERIALIZABLE_HISTORY);

        getWindow().setStatusBarColor(ContextCompat.getColor(HistoryInfoActivity.this, R.color.darkRed));
        getSupportActionBar().setTitle("History");

        //set progress for steps
//        stepSeekBar.setProgress(40);

        //setting seekbar to be unmovable
//        stepSeekBar.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        viewPager = findViewById(R.id.historyInfoPager);
        pagerAdapter = new HistoryInfoActivity.HistoryInfoAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(2);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer(){
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewPager.setPageTransformer(compositePageTransformer);
    }

    @Override

    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class HistoryInfoAdapter extends FragmentStateAdapter {
        public HistoryInfoAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch(position) {
                case 0:
                    return new HistoryLeftFootFragment(history);
                case 1:
                    return new HistoryRightFootFragment(history);
            }
            return new HistoryLeftFootFragment(history);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}