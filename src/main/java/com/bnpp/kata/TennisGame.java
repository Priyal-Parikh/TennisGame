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
        if(checkForDeuce())
            return TennisConstants.SCORE_DEUCE;

        if(checkForAdvantage())
            return TennisConstants.SCORE_ADVANTAGE+TennisConstants.COLON+(pointsScoredByFirstPlayer>pointsScoredBySecondPlayer?nameOfPlayerOne:nameOfPlayerTwo);

        if (checkForWinner()) {
            return TennisConstants.SCORE_WINS+TennisConstants.COLON+(pointsScoredByFirstPlayer>pointsScoredBySecondPlayer?nameOfPlayerOne:nameOfPlayerTwo);
        }

        String firstPlayerTranslatedScore=translateScoreInWord(getPointsScoredByFirstPlayer());
        String secondPlayerTranslatedScore=translateScoreInWord(getPointsScoredBySecondPlayer());
        String currentGameScore;

        if(isSamePointsScored(firstPlayerTranslatedScore, secondPlayerTranslatedScore))
            currentGameScore = firstPlayerTranslatedScore + TennisConstants.COLON + TennisConstants.TXT_ALL;
        else
            currentGameScore = firstPlayerTranslatedScore + TennisConstants.COLON + secondPlayerTranslatedScore;

        return currentGameScore;
    }

    private boolean checkForWinner() {
        if(pointsScoredBySecondPlayer > TennisConstants.THREE_POINT && pointsScoredBySecondPlayer >= pointsScoredByFirstPlayer + TennisConstants.TWO_POINT)
            return true;
        else return pointsScoredByFirstPlayer > TennisConstants.THREE_POINT && pointsScoredByFirstPlayer >= pointsScoredBySecondPlayer + TennisConstants.TWO_POINT;
    }

    private boolean checkForAdvantage() {
        return hasAnyPlayerScoreBeyondForty() && singlePointDifference();
    }

    private boolean singlePointDifference() {
        return Math.abs(pointsScoredBySecondPlayer-pointsScoredByFirstPlayer)== TennisConstants.ONE_POINT;
    }

    private boolean isSamePointsScored(String firstPlayerTranslatedScore, String secondPlayerTranslatedScore) {
        return firstPlayerTranslatedScore.equalsIgnoreCase(secondPlayerTranslatedScore);
    }

    private boolean hasAnyPlayerScoreBeyondForty() {
        return pointsScoredByFirstPlayer > TennisConstants.THREE_POINT || pointsScoredBySecondPlayer > TennisConstants.THREE_POINT;
    }

    private boolean checkForDeuce() {
        return getPointsScoredByFirstPlayer() > TennisConstants.THREE_POINT && getPointsScoredByFirstPlayer() == getPointsScoredBySecondPlayer();
    }

    private String translateScoreInWord(int score) {
        return TennisConstants.TENNIS_SCORE_LIST[score];
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
