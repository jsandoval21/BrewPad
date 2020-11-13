package com.fatmenbrews.brewpad;

import java.util.UUID;

public class Brew {
    private UUID mId;
    private String mBrewName;

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
}
