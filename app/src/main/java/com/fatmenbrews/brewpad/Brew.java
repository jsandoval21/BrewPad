package com.fatmenbrews.brewpad;

import java.util.UUID;

public class Brew {
    private UUID mId;
    private String mBrewName;
    private String mStyle;
    private String mMethod;
    private String mBatchSize;
    private String mBatchSizeUnits;
    private String mPreBoilSize;
    private String mPreBoilSizeUnits;
    private String mPostBoilSize;
    private String mPostBoilSizeUnits;
    private String mEfficiency;

    public Brew(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getBrewName() {
        return mBrewName;
    }

    public void setBrewName(String mBrewName) {
        this.mBrewName = mBrewName;
    }

    public String getmStyle() {
        return mStyle;
    }

    public void setmStyle(String mStyle) {
        this.mStyle = mStyle;
    }

    public String getmMethod() {
        return mMethod;
    }

    public void setmMethod(String mMethod) {
        this.mMethod = mMethod;
    }

    public String getmBatchSize() {
        return mBatchSize;
    }

    public void setmBatchSize(String mBatchSize) {
        this.mBatchSize = mBatchSize;
    }

    public String getmBatchSizeUnits() {
        return mBatchSizeUnits;
    }

    public void setmBatchSizeUnits(String mBatchSizeUnits) {
        this.mBatchSizeUnits = mBatchSizeUnits;
    }

    public String getmPreBoilSize() {
        return mPreBoilSize;
    }

    public void setmPreBoilSize(String mPreBoilSize) {
        this.mPreBoilSize = mPreBoilSize;
    }

    public String getmPreBoilSizeUnits() {
        return mPreBoilSizeUnits;
    }

    public void setmPreBoilSizeUnits(String mPreBoilSizeUnits) {
        this.mPreBoilSizeUnits = mPreBoilSizeUnits;
    }

    public String getmPostBoilSize() {
        return mPostBoilSize;
    }

    public void setmPostBoilSize(String mPostBoilSize) {
        this.mPostBoilSize = mPostBoilSize;
    }

    public String getmPostBoilSizeUnits() {
        return mPostBoilSizeUnits;
    }

    public void setmPostBoilSizeUnits(String mPostBoilSizeUnits) {
        this.mPostBoilSizeUnits = mPostBoilSizeUnits;
    }

    public String getmEfficiency() {
        return mEfficiency;
    }

    public void setmEfficiency(String mEfficiency) {
        this.mEfficiency = mEfficiency;
    }
}
