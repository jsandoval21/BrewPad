package com.fatmenbrews.brewpad;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrewLab {
    private static BrewLab sBrewLab;
    private List<Brew> mBrews;

    public static BrewLab get(Context context){
        if(sBrewLab == null){
            sBrewLab = new BrewLab(context);
        }

        return sBrewLab;
    }

    public BrewLab(Context context){
        mBrews = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Brew brew = new Brew();
            brew.setBrewName("Brew #" + i);
            mBrews.add(brew);
        }
    }

    public List<Brew> getBrews(){
        return mBrews;
    }

    public Brew getBrew(UUID id){
        for(Brew brew : mBrews){
            return brew;
        }

        return null;
    }
}
