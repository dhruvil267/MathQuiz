package com.example.mathquiz.controller;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.versionedparcelable.VersionedParcel;

import com.example.mathquiz.R;
import com.example.mathquiz.model.Questao;
import com.example.mathquiz.model.QuestionAnalysis;
import com.example.mathquiz.model.QuestoReposotiry;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Quizactivity extends Activity {
    public static final String QUESTIONINDEX="QUESTIONINDEX";
    private QuestoReposotiry repository=new QuestoReposotiry();
    private final Locale locale=new Locale("en","US");
    private int questionindex=0;
    private TextView questionview;
    private Button ansbutton1;
    private Button ansbutton2;
    private Button buttonNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Questao question=repository.getListQuestions().get(questionindex);

        questionview=findViewById(R.id.QuestionView);
        //questionview.setText(question.getText());


        View.OnClickListener listener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionAnalysis questionAnalysis = new QuestionAnalysis();
                String msg;
                final String answer = ((Button) v).getText().toString();
                Questao question = repository.getListQuestions().get(questionindex);
                try {
                    NumberFormat format=NumberFormat.getInstance(locale);
                    Number number=format.parse(answer);
                    if (questionAnalysis.isAnsCorrect(question, number.doubleValue())) {
                        msg = "Congrats,correct answer!";

                    } else {
                        msg = "AHH, Wrong answer!";
                    }

                }catch (ParseException e){
                    msg =e.getMessage();
                };
                Toast.makeText(Quizactivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        };
        ansbutton1=findViewById(R.id.Ans1_button);
        ansbutton1.setOnClickListener(listener);


        ansbutton2=findViewById(R.id.Ans2_button);
        ansbutton2.setOnClickListener(listener);


        View.OnClickListener listnernextquestion=new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionindex++;

                if(questionindex>=repository.getListQuestions().size()){
                    questionindex=0;
                }
                showquestion(questionindex);
            }
        };


        buttonNext=findViewById(R.id.Next_Ques_button);
        buttonNext.setOnClickListener(listnernextquestion);
        if (savedInstanceState !=null) {
            questionindex=savedInstanceState.getInt(QUESTIONINDEX);
        }
        showquestion(questionindex);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(QUESTIONINDEX, questionindex);
    }
    public void showquestion(final int questionindex){
        Questao question=repository.getListQuestions().get(questionindex);
        questionview.setText(question.getText());

        String rightanswer = String.format(locale, "%.2f", question.getRightanswer());
        String wronganswer = String.format(locale, "%.2f", question.getWronganswer());

        ansbutton1.setText(rightanswer);
        ansbutton2.setText(wronganswer);
        buttonNext.setText("Next Question");

    }

}
