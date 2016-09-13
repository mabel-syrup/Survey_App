package com.surber.matthew.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        final EditText question = (EditText) findViewById(R.id.question_change);
        final EditText answerYes = (EditText) findViewById(R.id.answer_yes_change);
        final EditText answerMaybe = (EditText) findViewById(R.id.answer_maybe_change);
        final EditText answerNo = (EditText) findViewById(R.id.answer_no_change);

        question.setText(Memory.getQuestion());
        answerYes.setText(Memory.getAnswerYes());
        answerNo.setText(Memory.getAnswerNo());
        answerMaybe.setText(Memory.getAnswerMaybe());


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Memory.setQuestion(question.getText().toString());
                Memory.setAnswerYes(answerYes.getText().toString());
                Memory.setAnswerNo(answerNo.getText().toString());
                Memory.setAnswerMaybe(answerMaybe.getText().toString());
                Intent resultIntent = new Intent();
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
