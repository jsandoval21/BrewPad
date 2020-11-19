package com.fatmenbrews.brewpad;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HopList {

    private static HopList sHopsList;
    private List<Hop> mHops;

    public static HopList get(Context context){
        if(sHopsList == null){
            sHopsList = new HopList(context);
        }

        return sHopsList;
    }

    public HopList(Context context){
        mHops = new ArrayList<>();
    }

    public void addHop(Hop hop){
        mHops.add(hop);
    }

    public void deleteHop(Hop hop) {
        mHops.remove(hop);
    }

    public List<Hop> getHops(){
        return mHops;
    }

    public Hop getHop(UUID id){
        for(Hop hops : mHops){
            return hops;
        }

        return null;
    }


}
