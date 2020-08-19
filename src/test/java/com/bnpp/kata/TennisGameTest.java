package com.bnpp.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TennisGameTest{
    TennisGame tennisGame;

    @Before
    public void initialSetup() {
        tennisGame=new TennisGame("Serena Williams","Maria Sharapova");
    }

    @Test
    public void initializeNewTennisGame() {
        assertNotNull( tennisGame );
    }

    @Test
    public void startNewGameWithTwoPlayers() {
        Assert.assertEquals("Serena Williams", tennisGame.getNameOfPlayerOne());
        Assert.assertEquals("Maria Sharapova", tennisGame.getNameOfPlayerTwo());
    }
}
