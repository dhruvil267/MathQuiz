package com.example.mathquiz.model;

public class Questao {
    private String text;
    private double rightanswer;
    private double wronganswer;

    public Questao(String text, double rightanswer,double wronganswer){
        this.text=text;
        this.rightanswer=rightanswer;
        this.wronganswer=wronganswer;
    }
    public String getText(){
        return text;
    }

    public double getRightanswer(){
        return rightanswer;
    }
    public double getWronganswer(){
        return wronganswer;
    }

}
