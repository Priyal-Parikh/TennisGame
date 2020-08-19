package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;

public class TennisGame {
    private String nameOfPlayerOne;
    private String nameOfPlayerTwo;
    private int pointsScoredByFirstPlayer;

    public TennisGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        this.nameOfPlayerOne = nameOfPlayerOne;
        this.nameOfPlayerTwo = nameOfPlayerTwo;
    }

    public String getCurrentGameScore() {
        return TennisConstants.SCORE_LOVE + " " + TennisConstants.TXT_ALL;
    }

    public void increaseAPointForFirstPlayer() {
        pointsScoredByFirstPlayer++;
    }

    public String getNameOfPlayerOne() {
        return nameOfPlayerOne;
    }

    public String getNameOfPlayerTwo() {
        return nameOfPlayerTwo;
    }

    public int getPointsScoredByFirstPlayer() {
        return pointsScoredByFirstPlayer;
    }
}
