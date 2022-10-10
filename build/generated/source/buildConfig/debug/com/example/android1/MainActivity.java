package com.example.android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends  AppCompatActivity{
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex = 0;

    private Question[] questions = new Question[]{
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, true),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true)
    };

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;
        if (userAnswer == correctAnswer) {
            resultMessageId = R.string.answer_true;
        } else {
            resultMessageId = R.string.answer_false;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.button_true);
        falseButton = findViewById(R.id.button_false);
        nextButton = findViewById(R.id.button_next);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                currentIndex = (currentIndex + 1) % questions.length;
                setNextQuestion();
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                currentIndex = (currentIndex + 1)% questions.length;
                setNextQuestion();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1)% questions.length;
                setNextQuestion();

            }
        });
        setNextQuestion();
    }
}
