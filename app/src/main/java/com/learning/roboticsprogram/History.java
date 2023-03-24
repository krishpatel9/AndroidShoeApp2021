package com.learning.roboticsprogram;

import android.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class History implements Serializable {
    public static final int STATUS_GOOD = 0;
    public static final int STATUS_BAD = 1;

    public static final String[] STATUS_TEXT = new String[]{
            "All Good!",
            "Very Bad"
            };





    private String date;
    private String time;
    private String thumbnail;
    private int stepCnt;
    private int stepGoal;
    private int numOfReadings;
    private int status_left; // --> 0 = Very Bad    1 = Bad     2 = Moderate    3 = All Good!
    private int status_right; // --> 0 = Very Bad    1 = Bad     2 = Moderate    3 = All Good!

    private ArrayList<double[]> readingList = new ArrayList<double[]>();
    private ArrayList<String> timeList = new ArrayList<String>();

    /*  readingList -->  [reading1L, reading2L, reading3L, reading4L, reading1R, reading2R, reading3R, reading4R]  */
    /*  timeList --> List containing all the times for the readings in the form of : h:mm:ss                       */


    public History(String date, String time, int stepCnt, int stepGoal) {
        this.date = date;
        this.time = time;
        this.stepCnt = stepCnt;
        this.stepGoal = stepGoal;
    }

    public Pair<String, double[]> getValuesByIndex(int i){
        return new Pair<>(timeList.get(i), readingList.get(i));
    }

    public Pair<String, double[]> getValuesByTime(String time){
        if(timeList.contains(time)){
            int index = timeList.indexOf(time);
            return new Pair<>(timeList.get(index), readingList.get(index));
        }
        else {
            return new Pair<>("00:00:00", new double[]{0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00});
        }
    }

    public Pair<String, double[]> getLeftValuesByIndex(int i){
        return new Pair<>(timeList.get(i),Arrays.copyOfRange(readingList.get(i),0,4));
    }
    public Pair<String, double[]> getLeftValuesByTime(String time){
        if(timeList.contains(time)){
            int index = timeList.indexOf(time);
            return new Pair<>(timeList.get(index), Arrays.copyOfRange(readingList.get(index),0,4));
        }
        else {
            return new Pair<>("0:00:00.000", new double[]{0.00, 0.00, 0.00, 0.00});
        }
    }

    public Pair<String, double[]> getRightValuesByIndex(int i){
        return new Pair<>(timeList.get(i),Arrays.copyOfRange(readingList.get(i),4,8));
    }
    public Pair<String, double[]> getRightValuesByTime(String time){
        if(timeList.contains(time)){
            int index = timeList.indexOf(time);
            return new Pair<>(timeList.get(index), Arrays.copyOfRange(readingList.get(index),4,8));
        }
        else {
            return new Pair<>("0:00:00.000", new double[]{0.00, 0.00, 0.00, 0.00});
        }
    }

    public void setStatus(int status_l, int status_r){
        status_left = status_l;
        status_right = status_r;
    }

    public int getStatus_left() {
        return status_left;
    }
    public void setStatus_left(int status) {
        this.status_left = status;
    }
    public int getStatus_right() {
        return status_right;
    }
    public void setStatus_right(int status_right) {
        this.status_right = status_right;
    }
    public void setReadings(ArrayList<String> times, ArrayList<double[]> readings){
        readingList = readings;
        timeList = times;
        updateNumOfReadings();
    }
    public void addReadings( String time, double[] arr){
        timeList.add(time);
        readingList.add(arr);
        updateNumOfReadings();
    }
    public void updateNumOfReadings(){
        numOfReadings = readingList.size();
    }
    public int getNumOfReadings() {
        return numOfReadings;
    }
    public void setStepCnt(int stepCnt) {
        this.stepCnt = stepCnt;
    }
    public int getStepCnt() {
        return stepCnt;
    }
    public void setStepGoal(int stepGoal) {
        this.stepGoal = stepGoal;
    }
    public int getStepGoal() {
        return stepGoal;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
