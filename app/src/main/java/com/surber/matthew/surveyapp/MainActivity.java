package com.surber.matthew.surveyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button yesButton;
    Button noButton;
    Button neutralButton;
    Button resultsButton;
    Button clearButton;
    TextView question;

    //Use an integer arraylist to store:
    //0 - disagree
    //1 - neutral
    //2 - agree
    //In one list for easy usage.
    ArrayList<Integer> results;

    private final static String SURVEY_KEY = "survey app key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            results = savedInstanceState.getIntegerArrayList(SURVEY_KEY);
        }

        if(results == null) {
            results = new ArrayList<>();
        }

        yesButton = (Button) findViewById(R.id.agreeButton);
        noButton = (Button) findViewById(R.id.disagreeButton);
        neutralButton = (Button) findViewById(R.id.neutralButton);
        resultsButton = (Button) findViewById(R.id.resultsButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        question = (TextView) findViewById(R.id.questionText);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add a "yes" result.
                results.add(2);
                System.out.println("SURVEY: Yes.");
                System.out.println("SURVEY: Votes: " + results.size());
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add a "no" result.
                results.add(0);
                System.out.println("SURVEY: No.");
                System.out.println("SURVEY: Votes: " + results.size());
            }
        });
        neutralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add a "maybe" result.
                results.add(1);
                System.out.println("SURVEY: Maybe.");
                System.out.println("SURVEY: Votes: " + results.size());
            }
        });
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Source: developer.android.com "Starting Another Activity" page.
                Intent resultIntent = new Intent(MainActivity.this,ResultsActivity.class);
                resultIntent.putIntegerArrayListExtra("resultList",results);
                startActivity(resultIntent);

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clearing results...",Toast.LENGTH_SHORT).show();
                results.clear();
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outBundle){
        outBundle.putIntegerArrayList(SURVEY_KEY,results);
    }
}
