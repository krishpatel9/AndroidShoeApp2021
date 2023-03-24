package com.learning.roboticsprogram.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "shoe")
public class Shoe implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date_time")
    private long dateTime;

    @ColumnInfo(name = "thumbnail")
    private String thumbnail;

    @ColumnInfo(name = "step_goal")
    private int stepGoal;

    @ColumnInfo(name = "step_count")
    private int stepCount;

    @ColumnInfo(name = "statusLeft")
    private int statusLeft;

    @ColumnInfo(name = "statusRight")
    private int statusRight;

    @ColumnInfo(name = "r1")
    private double r1;

    @ColumnInfo(name = "r2")
    private double r2;

    @ColumnInfo(name = "r3")
    private double r3;

    @ColumnInfo(name = "r4")
    private double r4;

    @ColumnInfo(name = "l1")
    private double l1;

    @ColumnInfo(name = "l2")
    private double l2;

    @ColumnInfo(name = "l3")
    private double l3;

    @ColumnInfo(name = "l4")
    private double l4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getStepGoal() {
        return stepGoal;
    }

    public void setStepGoal(int stepGoal) {
        this.stepGoal = stepGoal;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public int getStatusLeft() {
        return statusLeft;
    }

    public void setStatusLeft(int statusLeft) {
        this.statusLeft = statusLeft;
    }

    public int getStatusRight() {
        return statusRight;
    }

    public void setStatusRight(int statusRight) {
        this.statusRight = statusRight;
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public double getR3() {
        return r3;
    }

    public void setR3(double r3) {
        this.r3 = r3;
    }

    public double getR4() {
        return r4;
    }

    public void setR4(double r4) {
        this.r4 = r4;
    }

    public double getL1() {
        return l1;
    }

    public void setL1(double l1) {
        this.l1 = l1;
    }

    public double getL2() {
        return l2;
    }

    public void setL2(double l2) {
        this.l2 = l2;
    }

    public double getL3() {
        return l3;
    }

    public void setL3(double l3) {
        this.l3 = l3;
    }

    public double getL4() {
        return l4;
    }

    public void setL4(double l4) {
        this.l4 = l4;
    }
}
