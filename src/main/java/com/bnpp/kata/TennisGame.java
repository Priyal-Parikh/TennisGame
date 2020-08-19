package com.bnpp.kata;

public class TennisGame {
    private String nameOfPlayerOne;
    private String nameOfPlayerTwo;

    public TennisGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        this.nameOfPlayerOne = nameOfPlayerOne;
        this.nameOfPlayerTwo = nameOfPlayerTwo;
    }

    public String getCurrentGameScore() {
        return "Love All";
    }

    public String getNameOfPlayerOne() {
        return nameOfPlayerOne;
    }

    public String getNameOfPlayerTwo() {
        return nameOfPlayerTwo;
    }
}
