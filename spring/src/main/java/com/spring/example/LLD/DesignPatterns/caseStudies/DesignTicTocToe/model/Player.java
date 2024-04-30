package com.spring.example.LLD.DesignPatterns.caseStudies.DesignTicTocToe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String name;
    private PlayingPiece playingPiece;


}
