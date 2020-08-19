package com.bnpp.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TennisGameTest{
    public static final String NAME_OF_FIRST_PLAYER = "Serena Williams";
    public static final String NAME_OF_SECOND_PLAYER = "Maria Sharapova";
    public static final String SCORE_LOVE = "Love";
    public static final String TXT_ALL = "All";
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
        Assert.assertEquals(SCORE_LOVE+" "+TXT_ALL,tennisGame.getCurrentGameScore());
    }
}
