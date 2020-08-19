package com.bnpp.kata;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TennisGameTest{

    @Test
    public void initializeNewTennisGame() {
        TennisGame tennisGame=new TennisGame();

        assertNotNull( tennisGame );
    }
}
