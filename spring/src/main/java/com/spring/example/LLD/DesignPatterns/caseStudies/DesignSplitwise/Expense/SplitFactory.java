package com.spring.example.LLD.DesignPatterns.caseStudies.DesignSplitwise.Expense;


import com.spring.example.LLD.DesignPatterns.caseStudies.DesignSplitwise.Expense.Split.EqualExpenseSplit;
import com.spring.example.LLD.DesignPatterns.caseStudies.DesignSplitwise.Expense.Split.ExpenseSplit;
import com.spring.example.LLD.DesignPatterns.caseStudies.DesignSplitwise.Expense.Split.PercentageExpenseSplit;
import com.spring.example.LLD.DesignPatterns.caseStudies.DesignSplitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
