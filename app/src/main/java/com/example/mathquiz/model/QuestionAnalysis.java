package com.example.mathquiz.model;

import com.example.mathquiz.model.Questao;

public class QuestionAnalysis {
    public boolean isAnsCorrect(Questao question, double answer){
        return question.getRightanswer()==answer;
    }
}
