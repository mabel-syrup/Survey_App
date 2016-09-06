package com.surber.matthew.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    ArrayList<Integer> results;

    TextView resultsListTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        results = getIntent().getIntegerArrayListExtra("resultList");

        if(results == null){
            results = new ArrayList<>();
            System.out.println("SURVEY: No results found.");
        }

        resultsListTV = (TextView) findViewById(R.id.resultsList);

        resultsListTV.setText(parseResults(results));

    }

    private String parseResults (ArrayList<Integer> results){

        int yesCount = 0;
        int noCount = 0;
        int neutralCount = 0;
        try {
            for (int i : results) {
                switch (i) {
                    case 0:
                        noCount++;
                        break;
                    case 1:
                        neutralCount++;
                        break;
                    case 2:
                        yesCount++;
                        break;
                }

            }
        }
        catch(NullPointerException n){
            System.out.println("No results set.");
        }
        return ("Yes: " + yesCount + "\nMaybe: " + neutralCount + "\nNo: " + noCount);

    }
}
