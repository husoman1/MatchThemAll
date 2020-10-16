package com.appitopu.matchthemall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameScreen extends AppCompatActivity {
    int sonKart = 0;
    int skor = 0;
    int hamle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Intent i = getIntent();
        final String s = i.getStringExtra("ad");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(s);
        GridLayout gr = (GridLayout) findViewById(R.id.grid);
        kart kartlar[] = new kart[16];
        for (int j = 1; j <= 16; j++) {
            kartlar[j - 1] = new kart(this, j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hamle++;
                    final kart k = (kart)v;
                    k.cevir();
                    if (sonKart >0){
                        final kart k2 = (kart) findViewById(sonKart);
                        if (k2.onPlanID==k.onPlanID&&k2.getId()!=k.getId()){
                            k2.cevrilebilir=false;
                            k.cevrilebilir=false;
                            sonKart =0;
                            skor++;
                            TextView tv = (TextView) findViewById(R.id.textView3);
                            TextView tv2 = (TextView) findViewById(R.id.textView5);
                            tv.setText("Score: "+skor);
                            tv2.setText("Total moves: "+hamle);
                            if (skor==8){
                                Intent i = new Intent(GameScreen.this,scoreboard.class);
                                i.putExtra("ham",hamle);
                                i.putExtra("isim",s);
                                startActivity(i);
                                //oyun bitti

                            }



                        }
                        else{

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();

                                }
                            },500);
                            sonKart =0;
                            TextView tv2 = (TextView) findViewById(R.id.textView5);
                            tv2.setText("Total moves: "+hamle);

                        }
                    }
                    else{
                        sonKart = k.getId();
                    }

                }
            });
        }

        for (int j=0;j<16;j++){
            int rg =(int) (Math.random()*16);
            kart k = kartlar[rg];
            kartlar[rg] = kartlar [j];
            kartlar[j] = k;
        }

        for (int j = 0; j < 16; j++)
            gr.addView(kartlar[j]);




    }
}
