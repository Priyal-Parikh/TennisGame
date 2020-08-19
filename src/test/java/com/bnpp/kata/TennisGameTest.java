package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
        tennisGame.increaseAPointForPlayer(tennisGame.getNameOfPlayerOne());
        tennisGame.increaseAPointForPlayer(tennisGame.getNameOfPlayerTwo());
        tennisGame.getCurrentGameScore();

        Assert.assertEquals(TennisConstants.SCORE_FIFTEEN+ TennisConstants.COLON +TennisConstants.TXT_ALL,tennisGame.getCurrentGameScore());
    }
}
