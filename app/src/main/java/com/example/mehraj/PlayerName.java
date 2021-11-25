package com.example.mehraj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerName extends AppCompatActivity {
    EditText playername;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        playername=findViewById(R.id.et_name);
        start=findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(  playername.getText().toString().isEmpty())
              {
                  playername.setError("Name is required");
                  return;
              }
                startGame();

            }
        });

    }


    void startGame()
    {
        SharedPrefrences.storePlayerName(this,playername.getText().toString());
        startActivity(new Intent(this,MainActivity.class));
    }
}