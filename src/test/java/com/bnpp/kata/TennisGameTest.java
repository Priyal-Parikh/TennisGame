package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTest{
    public static final String NAME_OF_FIRST_PLAYER = "Serena Williams";
    public static final String NAME_OF_SECOND_PLAYER = "Maria Sharapova";
    TennisGame tennisGame;

    @Before
    public void initialSetup() {
        tennisGame=new TennisGame(NAME_OF_FIRST_PLAYER,"Maria Sharapova");
    }

    @Test
    public void initializeNewTennisGame() {
        assertNotNull( tennisGame );
    }

    @Test
    public void startNewGameWithTwoPlayers() {
        Assert.assertEquals(NAME_OF_FIRST_PLAYER, tennisGame.getNameOfPlayerOne());
        Assert.assertEquals(NAME_OF_SECOND_PLAYER, tennisGame.getNameOfPlayerTwo());
    }

    @Test
    public void initialScoreShouldBeLoveAll() {
        Assert.assertEquals(TennisConstants.SCORE_LOVE + TennisConstants.COLON +TennisConstants.TXT_ALL,tennisGame.getCurrentGameScore());
    }

    @Test
    public void firstPlayerScoreShouldIncreaseAfterWinningAPoint() {
        tennisGame.increaseAPointForPlayer(tennisGame.getNameOfPlayerOne());

        Assert.assertEquals(TennisConstants.ONE_POINT,tennisGame.getPointsScoredByFirstPlayer());
    }

    @Test
    public void secondPlayerScoreShouldIncreaseAfterWinningAPoint() {
        tennisGame.increaseAPointForPlayer(tennisGame.getNameOfPlayerTwo());

        Assert.assertEquals(TennisConstants.ONE_POINT,tennisGame.getPointsScoredBySecondPlayer());
    }

    @Test
    public void scoreShouldBeLoveFifteenIfSecondPlayerScoresPoint() {
        tennisGame.increaseAPointForPlayer(tennisGame.getNameOfPlayerTwo());
        tennisGame.getCurrentGameScore();

        Assert.assertEquals(TennisConstants.SCORE_LOVE+ TennisConstants.COLON +TennisConstants.SCORE_FIFTEEN,tennisGame.getCurrentGameScore());
    }

    @Test
    public void scoreShouldReturnFifteenAllIfBothPlayerWinsFirstPoint() {
        prepareScoreCard(TennisConstants.ONE_POINT,TennisConstants.ONE_POINT);
        tennisGame.getCurrentGameScore();

        Assert.assertEquals(TennisConstants.SCORE_FIFTEEN+ TennisConstants.COLON +TennisConstants.TXT_ALL,tennisGame.getCurrentGameScore());
    }

    @Test
    public void scoreShouldBeThirtyFifteenIfFirstPlayerScoresTwoAndSecondPlayerScoresOnePoint() {
        prepareScoreCard(TennisConstants.TWO_POINT,TennisConstants.ONE_POINT);
        tennisGame.getCurrentGameScore();

        Assert.assertEquals(TennisConstants.SCORE_THIRTY+ TennisConstants.COLON +TennisConstants.SCORE_FIFTEEN,tennisGame.getCurrentGameScore());
    }

    @Test
    @Parameters({
            "1, 0, Fifteen:Love",
            "1, 1, Fifteen:All",
            "2, 0, Thirty:Love",
            "3, 1, Forty:Fifteen",
            "3, 2, Forty:Thirty",
            "0, 3, Love:Forty",
            "1, 3, Fifteen:Forty",
            "2, 3, Thirty:Forty",
            "3, 3, Forty:All"
    })
    public void outputScoreShouldBeAsPerParametersPassed(int firstPlayerPoints,int secondPlayerPoints, String currentGameScore) {
        prepareScoreCard(firstPlayerPoints,secondPlayerPoints);

        Assert.assertEquals(currentGameScore,tennisGame.getCurrentGameScore());
    }

    private void prepareScoreCard(int firstPlayerPoints, int secondPlayerPoints) {
        for(int counter=0; counter<firstPlayerPoints; counter++)
            tennisGame.increaseAPointForPlayer(NAME_OF_FIRST_PLAYER);
        for(int counter=0; counter<secondPlayerPoints; counter++)
            tennisGame.increaseAPointForPlayer(NAME_OF_SECOND_PLAYER);
    }
}
