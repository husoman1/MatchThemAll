package com.appitopu.matchthemall;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatDrawableManager;

import com.appitopu.matchthemall.R;

public class karthard extends Button {
    boolean acikMihard = false;
    boolean cevrilebilirhard = true;
    int arkaPlanIDhard;
    int onPlanIDhard=0;
    Drawable onhard;
    Drawable dhard;
    public karthard(Context context, int id) {
        super(context);
        setId(id);
        arkaPlanIDhard = R.drawable.arka1;
        if(id%12==1)
            onPlanIDhard =  R.drawable.c1;
        if(id%12==2)
            onPlanIDhard =  R.drawable.c2;
        if(id%12==3)
            onPlanIDhard =  R.drawable.c3;
        if(id%12==4)
            onPlanIDhard =  R.drawable.c4;
        if(id%12==5)
            onPlanIDhard =  R.drawable.c5;
        if(id%12==6)
            onPlanIDhard =  R.drawable.c6;
        if(id%12==7)
            onPlanIDhard =  R.drawable.c7;
        if(id%12==8)
            onPlanIDhard =  R.drawable.c8;
        if(id%12==9)
            onPlanIDhard =  R.drawable.c9;
        if(id%12==10)
            onPlanIDhard =  R.drawable.c10;
        if(id%12==11)
            onPlanIDhard =  R.drawable.c11;
        if(id%12==0)
            onPlanIDhard =  R.drawable.c12;
        dhard = AppCompatDrawableManager.get().getDrawable(context,arkaPlanIDhard);
        onhard = AppCompatDrawableManager.get().getDrawable(context, onPlanIDhard);
        setBackground(dhard);


    }
    public void cevirhard(){
        if (cevrilebilirhard){
            if(!acikMihard){
                setBackground(onhard);
                acikMihard = true;
            }
            else{
                setBackground(dhard);
                acikMihard=false;
            }

        }

    }
}
