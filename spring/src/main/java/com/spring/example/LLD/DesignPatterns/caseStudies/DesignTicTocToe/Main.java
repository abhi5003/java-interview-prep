package com.spring.example.LLD.DesignPatterns.caseStudies.DesignTicTocToe;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      TicTocToeGame ticTocToeGame=new TicTocToeGame();
      ticTocToeGame.initializeGame();
      ticTocToeGame.startGame();

/*
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");


       list.stream().mapToInt(i-> Integer.parseInt(i)).filter(i->i%2==0).
       forEach(System.out::println);

 */
    }
}
