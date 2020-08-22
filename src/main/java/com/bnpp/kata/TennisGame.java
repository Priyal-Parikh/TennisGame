package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;
import com.bnpp.kata.exception.TennisException;

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
        if (checkForDeuce()) {
            return TennisConstants.SCORE_DEUCE;
        } else if (checkForAdvantage()) {
            return TennisConstants.SCORE_ADVANTAGE + TennisConstants.COLON + (getPlayerWithHighScore());
        } else if (checkForWinner()) {
            return TennisConstants.SCORE_WINS + TennisConstants.COLON + getPlayerWithHighScore();
        } else return convertScore();
    }

    public void increaseAPointForPlayer(String pointWinnerPlayer) {
        if (isInvalidPlayerName(pointWinnerPlayer)) throw new TennisException("Incorrect Player Name");
        if (pointWinnerPlayer.equalsIgnoreCase(nameOfPlayerOne))
            pointsScoredByFirstPlayer++;
        else pointsScoredBySecondPlayer++;
    }

    public boolean isInvalidPlayerName(String inputPlayer) {
        return !isPlayerNameNotNull(inputPlayer) || (!inputPlayer.equalsIgnoreCase(nameOfPlayerOne) && (!inputPlayer.equalsIgnoreCase(nameOfPlayerTwo)));
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

    private String convertScore() {
        TennisScoreEnum firstPlayerTranslatedScore = translateScoreForTennisFormat(getPointsScoredByFirstPlayer());
        TennisScoreEnum secondPlayerTranslatedScore = translateScoreForTennisFormat(getPointsScoredBySecondPlayer());

        return isSamePointsScored() ?
                firstPlayerTranslatedScore.score + TennisConstants.COLON + TennisConstants.TXT_ALL :
                firstPlayerTranslatedScore.score + TennisConstants.COLON + secondPlayerTranslatedScore.score;
    }

    private boolean isPlayerNameNotNull(String playerName) {
        return !(null == playerName) && !("".equals(playerName));
    }

    private String getPlayerWithHighScore() {
        return pointsScoredByFirstPlayer > pointsScoredBySecondPlayer ? nameOfPlayerOne : nameOfPlayerTwo;
    }

    private boolean checkForWinner() {
        return hasAnyPlayerScoreBeyondForty() && isPointDifferenceTwoOrMore();
    }

    private boolean isPointDifferenceTwoOrMore() {
        return Math.abs(pointsScoredBySecondPlayer - pointsScoredByFirstPlayer) >= TennisConstants.TWO_POINT;
    }

    private boolean checkForAdvantage() {
        return hasAnyPlayerScoreBeyondForty() && isSinglePointDifference();
    }

    private boolean isSinglePointDifference() {
        return Math.abs(pointsScoredBySecondPlayer - pointsScoredByFirstPlayer) == TennisConstants.ONE_POINT;
    }

    private boolean isSamePointsScored() {
        return pointsScoredByFirstPlayer == pointsScoredBySecondPlayer;
    }

    private boolean hasAnyPlayerScoreBeyondForty() {
        return pointsScoredByFirstPlayer > TennisConstants.THREE_POINT || pointsScoredBySecondPlayer > TennisConstants.THREE_POINT;
    }

    private boolean checkForDeuce() {
        return getPointsScoredByFirstPlayer() > TennisConstants.TWO_POINT && isSamePointsScored();
    }

    private TennisScoreEnum translateScoreForTennisFormat(int score) {
        return TennisScoreEnum.fromScore(score);
    }
}
