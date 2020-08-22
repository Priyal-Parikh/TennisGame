package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;
import com.bnpp.kata.entity.TennisPlayer;
import com.bnpp.kata.exception.TennisException;

public class TennisGame {
    TennisPlayer firstPlayer;
    TennisPlayer secondPlayer;

    public TennisGame(String nameOfPlayerOne, String nameOfPlayerTwo) {
        firstPlayer=new TennisPlayer(nameOfPlayerOne);
        secondPlayer=new TennisPlayer(nameOfPlayerTwo);
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
        if (pointWinnerPlayer.equalsIgnoreCase(firstPlayer.getNameOfPlayer()))
            firstPlayer.setPointsScoredByPlayer(firstPlayer.getPointsScoredByPlayer()+TennisConstants.ONE_POINT);
        else secondPlayer.setPointsScoredByPlayer(secondPlayer.getPointsScoredByPlayer()+TennisConstants.ONE_POINT);
    }

    public boolean isInvalidPlayerName(String inputPlayer) {
        return !isPlayerNameNotNull(inputPlayer) || (!inputPlayer.equalsIgnoreCase(firstPlayer.getNameOfPlayer()) && (!inputPlayer.equalsIgnoreCase(secondPlayer.getNameOfPlayer())));
    }

    private String convertScore() {
        TennisScoreEnum firstPlayerTranslatedScore = translateScoreForTennisFormat(firstPlayer.getPointsScoredByPlayer());
        TennisScoreEnum secondPlayerTranslatedScore = translateScoreForTennisFormat(secondPlayer.getPointsScoredByPlayer());

        return isSamePointsScored() ?
                firstPlayerTranslatedScore.score + TennisConstants.COLON + TennisConstants.TXT_ALL :
                firstPlayerTranslatedScore.score + TennisConstants.COLON + secondPlayerTranslatedScore.score;
    }

    private boolean isPlayerNameNotNull(String playerName) {
        return !(null == playerName) && !("".equals(playerName));
    }

    private String getPlayerWithHighScore() {
        return firstPlayer.getPointsScoredByPlayer() > secondPlayer.getPointsScoredByPlayer() ? firstPlayer.getNameOfPlayer() : secondPlayer.getNameOfPlayer();
    }

    private boolean checkForWinner() {
        return hasAnyPlayerScoreBeyondForty() && isPointDifferenceTwoOrMore();
    }

    private boolean isPointDifferenceTwoOrMore() {
        return Math.abs(secondPlayer.getPointsScoredByPlayer() - firstPlayer.getPointsScoredByPlayer()) >= TennisConstants.TWO_POINT;
    }

    private boolean checkForAdvantage() {
        return hasAnyPlayerScoreBeyondForty() && isSinglePointDifference();
    }

    private boolean isSinglePointDifference() {
        return Math.abs(secondPlayer.getPointsScoredByPlayer() - firstPlayer.getPointsScoredByPlayer()) == TennisConstants.ONE_POINT;
    }

    private boolean isSamePointsScored() {
        return firstPlayer.getPointsScoredByPlayer() == secondPlayer.getPointsScoredByPlayer();
    }

    private boolean hasAnyPlayerScoreBeyondForty() {
        return firstPlayer.getPointsScoredByPlayer() > TennisConstants.THREE_POINT || secondPlayer.getPointsScoredByPlayer() > TennisConstants.THREE_POINT;
    }

    private boolean checkForDeuce() {
        return firstPlayer.getPointsScoredByPlayer() > TennisConstants.TWO_POINT && isSamePointsScored();
    }

    private TennisScoreEnum translateScoreForTennisFormat(int score) {
        return TennisScoreEnum.fromScore(score);
    }
}
