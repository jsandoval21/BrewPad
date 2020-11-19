package com.fatmenbrews.brewpad;

import java.util.UUID;

public class Hop {

    private UUID mId;
    private String mAmount;
    private String mAmountUnit;
    private String mVariety;
    private String mAlphaAcid;
    private String mBillPercent;
    private String mAdditionTime;
    private String mType;
    private String mUse;
    private String mIBU;

    public Hop(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String mAmount) {
        this.mAmount = mAmount;
    }

    public String getAmountUnit() {
        return mAmountUnit;
    }

    public void setAmountUnit(String mAmountUnit) {
        this.mAmountUnit = mAmountUnit;
    }

    public String getVariety() {
        return mVariety;
    }

    public void setVariety(String mVariety) {
        this.mVariety = mVariety;
    }

    public String getAlphaAcid() {
        return mAlphaAcid;
    }

    public void setAlphaAcid(String mAlphaAcid) {
        this.mAlphaAcid = mAlphaAcid;
    }

    public String getBillPercent() {
        return mBillPercent;
    }

    public void setBillPercent(String mBillPercent) {
        this.mBillPercent = mBillPercent;
    }

    public String getAdditionTime() {
        return mAdditionTime;
    }

    public void setAdditionTime(String mAdditionTime) {
        this.mAdditionTime = mAdditionTime;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getUse() {
        return mUse;
    }

    public void setUse(String mUse) {
        this.mUse = mUse;
    }

    public String getIBU() {
        return mIBU;
    }

    public void setIBU(String mIBU) {
        this.mIBU = mIBU;
    }
}
