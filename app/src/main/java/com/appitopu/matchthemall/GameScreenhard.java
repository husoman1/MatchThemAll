package com.appitopu.matchthemall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class GameScreenhard extends AppCompatActivity {
    int sonKarthard = 0;
    int skorhard = 0;
    int hamlehard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Intent i = getIntent();
        final String s = i.getStringExtra("ad");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(s);
        GridLayout gr = (GridLayout) findViewById(R.id.grid);
        karthard kartlarhard[] = new karthard[24];
        for (int j = 1; j <= 24; j++) {
            kartlarhard[j - 1] = new karthard(this, j);
            kartlarhard[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hamlehard++;
                    final karthard khard = (karthard) v;
                    khard.cevirhard();
                    if (sonKarthard >0){
                        final karthard k2hard = (karthard) findViewById(sonKarthard);
                        if (k2hard.onPlanIDhard==khard.onPlanIDhard&&k2hard.getId()!=khard.getId()){
                            k2hard.cevrilebilirhard=false;
                            khard.cevrilebilirhard=false;
                            sonKarthard =0;
                            skorhard++;
                            TextView tv = (TextView) findViewById(R.id.textView3);
                            TextView tv2 = (TextView) findViewById(R.id.textView5);
                            tv.setText("Score: "+skorhard);
                            tv2.setText("Total moves: "+hamlehard);
                            if (skorhard==12){
                                Intent i = new Intent(GameScreenhard.this,scoreboard.class);
                                i.putExtra("ham",hamlehard);
                                i.putExtra("isim",s);
                                startActivity(i);
                                //oyun bitti

                            }



                        }
                        else{
                            Handler z = new Handler();
                            z.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2hard.cevirhard();
                                    khard.cevirhard();

                                }
                            },500);
                            sonKarthard =0;
                            TextView tv2 = (TextView) findViewById(R.id.textView5);
                            tv2.setText("Total moves: "+hamlehard);

                        }
                    }
                    else{
                        sonKarthard = khard.getId();
                    }

                }
            });
        }

        for (int j=0;j<24;j++){
            int rg =(int) (Math.random()*24);
            karthard k = kartlarhard[rg];
            kartlarhard[rg] = kartlarhard [j];
            kartlarhard[j] = k;
        }

        for (int j = 0; j < 24; j++)
            gr.addView(kartlarhard[j]);




    }
}
