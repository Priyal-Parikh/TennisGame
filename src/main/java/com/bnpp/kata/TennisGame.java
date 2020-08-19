package com.bnpp.kata;

public class TennisGame {
    private static final String SCORE_LOVE = "Love";
    private static final String TXT_ALL = "All";
    private String nameOfPlayerOne;
    private String nameOfPlayerTwo;

    public TennisGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        this.nameOfPlayerOne = nameOfPlayerOne;
        this.nameOfPlayerTwo = nameOfPlayerTwo;
    }

    public String getCurrentGameScore() {
        return SCORE_LOVE + " " + TXT_ALL;
    }

    public String getNameOfPlayerOne() {
        return nameOfPlayerOne;
    }

    public String getNameOfPlayerTwo() {
        return nameOfPlayerTwo;
    }
}
