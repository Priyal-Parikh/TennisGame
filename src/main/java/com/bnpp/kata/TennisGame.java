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
        String currentGameScore;

        if(checkForDeuce()) {
            currentGameScore = TennisConstants.SCORE_DEUCE;
        }

        else if(checkForAdvantage()) {
            currentGameScore = TennisConstants.SCORE_ADVANTAGE + TennisConstants.COLON + (getPlayerWithHighScore());
        }

        else if (checkForWinner()) {
            currentGameScore=TennisConstants.SCORE_WINS+TennisConstants.COLON+ getPlayerWithHighScore();
        }

        else {
            currentGameScore = convertScore();
        }

        return currentGameScore;
    }

    private String convertScore() {
        TennisScoreEnum firstPlayerTranslatedScore = translateScoreForTennisFormat(getPointsScoredByFirstPlayer());
        TennisScoreEnum secondPlayerTranslatedScore = translateScoreForTennisFormat(getPointsScoredBySecondPlayer());

        return isSamePointsScored() ?
                firstPlayerTranslatedScore + TennisConstants.COLON + TennisConstants.TXT_ALL :
                firstPlayerTranslatedScore + TennisConstants.COLON + secondPlayerTranslatedScore;
    }

    private String getPlayerWithHighScore() {
        return pointsScoredByFirstPlayer > pointsScoredBySecondPlayer ? nameOfPlayerOne : nameOfPlayerTwo;
    }

    private boolean checkForWinner() {
        if(pointsScoredBySecondPlayer > TennisConstants.THREE_POINT && pointsScoredBySecondPlayer >= pointsScoredByFirstPlayer + TennisConstants.TWO_POINT)
            return true;
        else return pointsScoredByFirstPlayer > TennisConstants.THREE_POINT && pointsScoredByFirstPlayer >= pointsScoredBySecondPlayer + TennisConstants.TWO_POINT;
    }

    private boolean checkForAdvantage() {
        return hasAnyPlayerScoreBeyondForty() && isSinglePointDifference();
    }

    private boolean isSinglePointDifference() {
        return Math.abs(pointsScoredBySecondPlayer-pointsScoredByFirstPlayer)== TennisConstants.ONE_POINT;
    }

    private boolean isSamePointsScored() {
        return pointsScoredByFirstPlayer==pointsScoredBySecondPlayer;
    }

    private boolean hasAnyPlayerScoreBeyondForty() {
        return pointsScoredByFirstPlayer > TennisConstants.THREE_POINT || pointsScoredBySecondPlayer > TennisConstants.THREE_POINT;
    }

    private boolean checkForDeuce() {
        return getPointsScoredByFirstPlayer() > TennisConstants.THREE_POINT && isSamePointsScored();
    }

    private TennisScoreEnum translateScoreForTennisFormat(int score) {
        return TennisScoreEnum.fromScore(score);
    }

    public void increaseAPointForPlayer(String pointWinnerPlayer) {
        if(pointWinnerPlayer!=null && !"".equals(pointWinnerPlayer)) {
            if (pointWinnerPlayer.equalsIgnoreCase(nameOfPlayerOne))
                pointsScoredByFirstPlayer++;
            else if (pointWinnerPlayer.equalsIgnoreCase(nameOfPlayerTwo))
                pointsScoredBySecondPlayer++;
        }
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
