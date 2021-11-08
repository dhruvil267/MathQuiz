package com.example.mathquiz.model;
import java.util.ArrayList;
import java.util.List;

import com.example.mathquiz.model.Questao;

public class QuestoReposotiry {
    public List<Questao> getListQuestions(){
        return new ArrayList<Questao>(){{
            add(new Questao("In a clothing store, 1500 clothes are sold daily for 7 days. How many days will 200 clothes be sold?",1,3));
            add(new Questao("In a steakhouse, 5 pigs are roasted, out of a total of 10. If it is necessary to roast 3 pigs for 50 people, how many pigs will need to be roasted for 250 people?",15,20));
            add(new Questao("In a print shop there are 3 printers that work without interruption, 10 hours a day, for 4 days, printing 240,000 sheets. Having broken one of the printers and needing to print 480,000 sheets in 6 days, how many hours a day should the remaining two machines run uninterrupted?",20,10));
            add(new Questao("Applying R$500.00 in savings, the amount of interest in a month would be R$2.50. If BRL 2100.00 is applied in the same month, what would be the interest amount?",14,10.5));
            add(new Questao("A plant produces 500 liters of alcohol from 6000 kg of sugarcane. Determine how many liters of alcohol are produced with 15000 kg of sugarcane.",750,1250));
        }

        };
    }
}
