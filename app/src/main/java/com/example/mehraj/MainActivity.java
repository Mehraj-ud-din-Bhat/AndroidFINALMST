package com.example.mehraj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Used attributes Buttons,TextViews,ImageViews
    Button b_rock,b_paper,b_scissor;
    TextView tv_score;
    ImageView iv_human,iv_computer;

    //Winner count
    int human,computer=0;

    String playerName="Human";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      TextView v=  findViewById(R.id.textView0);
       playerName=SharedPrefrences.getPlayerName(this);
        v.setText(playerName);
        //Assigning attributes to their resources
        b_rock = (Button) findViewById(R.id.rockButton);
        b_paper = (Button) findViewById(R.id.paperButton);
        b_scissor = (Button) findViewById(R.id.scissorButton);

        tv_score = (TextView) findViewById(R.id.scoreTextView);

        iv_computer = (ImageView) findViewById(R.id.computerImageView);
        iv_human = (ImageView) findViewById(R.id.humanImageView);


        //Rock button action method
        b_rock.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick (View view){

                iv_human.setImageResource(R.drawable.rock);
                String message = playTurn("rock");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score : "+playerName+ " " + Integer.toString(human) + ": " +"Computer " + Integer.toString(computer));



            }
        });


        //Paper button action method
        b_paper.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick (View view){

                iv_human.setImageResource(R.drawable.paper);
                String message = playTurn("paper");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score : "+playerName+ " " + Integer.toString(human) + ": " +"Computer " + Integer.toString(computer));


            }
        });

        //Scissors button action method
        b_scissor.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick (View view){

                iv_human.setImageResource(R.drawable.scissor);
                String message = playTurn("scissor");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                tv_score.setText("Score : "+playerName+ " " + Integer.toString(human) + ": " +"Computer " + Integer.toString(computer));


            }
        });

    }

    //Method to determine the winner
    public String playTurn(String playerChoice){

        String computerChoice = "";
        Random r = new Random();

        //Generating random numbers 1,2 or 3
        int computerChoiceNumber = r.nextInt(3)+1;

        //Determining computer's choice
        if(computerChoiceNumber==1){

            computerChoice = "rock";
            iv_computer.setImageResource(R.drawable.rock);

        }
        else if(computerChoiceNumber==2){

            computerChoice = "paper";
            iv_computer.setImageResource(R.drawable.paper);

        }
        else if(computerChoiceNumber==3){

            computerChoice = "scissor";
            iv_computer.setImageResource(R.drawable.scissor);

        }


        //Determining the winner
        if(playerChoice == computerChoice){

            return "Draw. Nobody wins.";

        }
        else if (playerChoice == "rock" && computerChoice == "paper"){

            computer++;
            return "Computer wins.";

        }
        else if (playerChoice == "rock" && computerChoice == "scissor"){

            human++;
            return "You win.";

        }
        else if (playerChoice == "paper" && computerChoice == "rock"){

            human++;
            return "You win.";

        }
        else if (playerChoice == "paper" && computerChoice == "scissor"){

            computer++;
            return "Computer wins.";

        }
        else if (playerChoice == "scissor" && computerChoice == "rock"){

            computer++;
            return "Computer wins.";

        }
        else if (playerChoice == "scissor" && computerChoice == "paper"){

            human++;
            return "You win.";

        }
        else return "Not Sure.";



    }
}
