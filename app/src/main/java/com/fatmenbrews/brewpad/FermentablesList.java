package com.fatmenbrews.brewpad;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FermentablesList {

    private static FermentablesList sFermentablesList;
    private List<Fermentable> mFermentables;

    public static FermentablesList get(Context context){
        if(sFermentablesList == null){
            sFermentablesList = new FermentablesList(context);
        }

        return sFermentablesList;
    }

    public FermentablesList(Context context){
        mFermentables = new ArrayList<>();
    }

    public void addFermentable(Fermentable fermentable){
        mFermentables.add(fermentable);
    }

    public void deleteFermentable(Fermentable fermentable) {
        mFermentables.remove(fermentable);
    }

    public List<Fermentable> getFermentables(){
        return mFermentables;
    }

    public Fermentable getFermentable(UUID id){
        for(Fermentable fermentable : mFermentables){
            return fermentable;
        }

        return null;
    }


}
