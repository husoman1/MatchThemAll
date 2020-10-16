package com.appitopu.matchthemall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        TextView tv = (TextView) findViewById(R.id.textView4);
        Intent i = getIntent();
        String isim = i.getStringExtra("isim");
        int skor = i.getIntExtra("ham",0);
        tv.setText("Congratulations "+isim+"!\nYou won with "+skor + " total move! ");


        ((Button) findViewById(R.id.button13)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(scoreboard.this, MainActivity.class);
                startActivity(i);


            }
        });
    }
}
