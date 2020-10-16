package com.appitopu.matchthemall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nickn = (EditText) findViewById(R.id.nicknameText);

        ((Button) findViewById(R.id.casualPlay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GameScreen.class);
                i.putExtra("ad",nickn.getText().toString());
                startActivity(i);
            }

        });
        ((Button) findViewById(R.id.hardPlay)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(MainActivity.this, GameScreenhard.class);
                x.putExtra("ad",nickn.getText().toString());
                startActivity(x);
            }

        });


    }
}
