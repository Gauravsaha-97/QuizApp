package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {
        //Defining the first set of radio buttons

        RadioButton viratKohli = (RadioButton) findViewById(R.id.virat);

        //Defining the Checkboxes

        CheckBox bradHaddin = (CheckBox) findViewById(R.id.haddin);
        CheckBox shaneWatson = (CheckBox) findViewById(R.id.watson);
        CheckBox matthewHayden = (CheckBox) findViewById(R.id.hayden);
        CheckBox chrisLynn = (CheckBox) findViewById(R.id.lynn);

        //Defining the second set of radio buttons


        RadioButton eoinMorgan = (RadioButton) findViewById(R.id.eoin);

        //Defining the EditText view
        EditText answer = (EditText) findViewById(R.id.enterAnswer);

        //Defining the boolean variables required in our program and calculating the scores
        boolean virat = viratKohli.isChecked();
        int score1 = question_1(virat);
        boolean matthew = matthewHayden.isChecked();
        boolean chris = chrisLynn.isChecked();
        boolean brad = bradHaddin.isChecked();
        boolean shane = shaneWatson.isChecked();
        int score2 = question_2(chris, matthew, brad, shane);
        boolean eoin = eoinMorgan.isChecked();
        int score3 = question_3(eoin);
        String player = answer.getText().toString();
        int score4 = question_4(player);
        score = score1 + score2 + score3 + score4;

        //Display the Toast Message
        Toast.makeText(this, "Score is " + score, Toast.LENGTH_SHORT).show();
        return;
    }

    //Defining the functions to calculate scores
    private int question_1(boolean virat) {
        int score1 = 0;
        if (virat == true) {
            score1 = score1 + 1;
        } else {
            score1 = score1 + 0;
        }
        return score1;

    }

    private int question_2(boolean chris, boolean matthew, boolean brad, boolean shane) {
        int score2 = 0;
        if (chris == true && matthew == true && !brad && !shane) {
            score2 = score2 + 2;
        }
        return score2;
    }

    private int question_3(boolean eoin) {
        int score3 = 0;
        if (eoin == true) {
            score3 = score3 + 1;
        }
        return score3;
    }

    private int question_4(String player) {
        int score4 = 0;
        if (player.contentEquals("Kapil Dev")) {
            score4 = score4 + 1;
        }
        return score4;
    }
}