package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;

public class TennisGame {
    private String nameOfPlayerOne;
    private String nameOfPlayerTwo;
    private int pointsScoredByFirstPlayer;
    private int pointsScoredBySecondPlayer;

    public TennisGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        this.nameOfPlayerOne = nameOfPlayerOne;
        this.nameOfPlayerTwo = nameOfPlayerTwo;
    }

    public String getCurrentGameScore() {
        String firstPlayerTranslatedScore=translateScoreInWord(getPointsScoredByFirstPlayer());
        String secondPlayerTranslatedScore=translateScoreInWord(getPointsScoredBySecondPlayer());
        String currentGameScore;

        if(firstPlayerTranslatedScore.equalsIgnoreCase(secondPlayerTranslatedScore))
            currentGameScore = firstPlayerTranslatedScore + TennisConstants.COLON + TennisConstants.TXT_ALL;
        else
            currentGameScore = firstPlayerTranslatedScore + TennisConstants.COLON + secondPlayerTranslatedScore;

        return currentGameScore;
    }

    private String translateScoreInWord(int score) {
        String translatedScore="";

        if (score == TennisConstants.ZERO_POINT) {
            translatedScore = TennisConstants.SCORE_LOVE;
        } else if (score == TennisConstants.ONE_POINT) {
            translatedScore = TennisConstants.SCORE_FIFTEEN;
        }
        return translatedScore;
    }

    public void increaseAPointForPlayer(String pointWinnerPlayer) {
        if(pointWinnerPlayer.equalsIgnoreCase(getNameOfPlayerOne()))
            pointsScoredByFirstPlayer++;
        else if(pointWinnerPlayer.equalsIgnoreCase(getNameOfPlayerTwo()))
            pointsScoredBySecondPlayer++;
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

    public int getPointsScoredBySecondPlayer() {
        return pointsScoredBySecondPlayer;
    }
}
