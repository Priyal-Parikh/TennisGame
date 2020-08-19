package com.bnpp.kata;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TennisGameTest{

    @Test
    public void initializeNewTennisGame() {
        TennisGame tennisGame=new TennisGame("Serena Williams","Maria Sharapova");

        assertNotNull( tennisGame );
    }

    @Test
    public void startNewGameWithTwoPlayers() {
        TennisGame tennisGame=new TennisGame("Serena Williams","Maria Sharapova");

        Assert.assertEquals("Serena Williams", tennisGame.getNameOfPlayerOne());
        Assert.assertEquals("Maria Sharapova", tennisGame.getNameOfPlayerTwo());
    }
}
