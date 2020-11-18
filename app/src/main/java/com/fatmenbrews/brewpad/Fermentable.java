package com.fatmenbrews.brewpad;

import java.util.UUID;

public class Fermentable {

    private UUID mID;
    private String mAmount;
    private String mUnits;
    private String mFermentable;
    private String mBillPercent;

    public Fermentable() {
        mID = UUID.randomUUID();
    }

    public UUID getID() {
        return mID;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String mAmount) {
        this.mAmount = mAmount;
    }

    public String getUnits() {
        return mUnits;
    }

    public void setUnits(String mUnits) {
        this.mUnits = mUnits;
    }

    public String getFermentable() {
        return mFermentable;
    }

    public void setFermentable(String mFermentable) {
        this.mFermentable = mFermentable;
    }

    public String getBillPercent() {
        return mBillPercent;
    }

    public void setBillPercent(String mBillPercent) {
        this.mBillPercent = mBillPercent;
    }
}
