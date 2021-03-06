package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;
import com.bnpp.kata.entity.TennisPlayer;
import com.bnpp.kata.exception.TennisException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnitParamsRunner.class)
public class TennisGameTest{
    public static final String NAME_OF_FIRST_PLAYER = "Serena Williams";
    public static final String NAME_OF_SECOND_PLAYER = "Maria Sharapova";
    TennisGame tennisGame;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void initialSetup() {
        tennisGame=new TennisGame(NAME_OF_FIRST_PLAYER,NAME_OF_SECOND_PLAYER);
    }

    @Test
    public void initializeNewTennisGame() {
        assertNotNull( tennisGame );
    }

    @Test
    public void startNewGameWithTwoPlayers() {
        Assert.assertEquals(NAME_OF_FIRST_PLAYER, tennisGame.firstPlayer.getNameOfPlayer());
        Assert.assertEquals(NAME_OF_SECOND_PLAYER, tennisGame.secondPlayer.getNameOfPlayer());
    }

    @Test
    public void initialScoreShouldBeLoveAll() {
        Assert.assertEquals(TennisConstants.SCORE_LOVE + TennisConstants.COLON +TennisConstants.TXT_ALL,tennisGame.getCurrentGameScore());
    }

    @Test
    public void firstPlayerScoreShouldIncreaseAfterWinningAPoint() {
        tennisGame.increaseAPointForPlayer(tennisGame.firstPlayer.getNameOfPlayer());

        Assert.assertEquals(TennisConstants.ONE_POINT,tennisGame.firstPlayer.getPointsScoredByPlayer());
    }

    @Test
    public void secondPlayerScoreShouldIncreaseAfterWinningAPoint() {
        tennisGame.increaseAPointForPlayer(tennisGame.secondPlayer.getNameOfPlayer());

        Assert.assertEquals(TennisConstants.ONE_POINT,tennisGame.secondPlayer.getPointsScoredByPlayer());
    }

    @Test
    public void scoreShouldThrowAnExceptionIfNameIfNotCorrect() {
        exceptionRule.expect(TennisException.class);
        exceptionRule.expectMessage("Incorrect Player Name");

        tennisGame.increaseAPointForPlayer("RANDOM PLAYER");
    }

    @Test
    public void scoreShouldBeLoveFifteenIfSecondPlayerScoresPoint() {
        tennisGame.increaseAPointForPlayer(tennisGame.secondPlayer.getNameOfPlayer());
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
            "2, 3, Thirty:Forty"
    })
    public void outputScoreShouldBeAsPerParametersPassed(int firstPlayerPoints,int secondPlayerPoints, String currentGameScore) {
        prepareScoreCard(firstPlayerPoints,secondPlayerPoints);

        Assert.assertEquals(currentGameScore,tennisGame.getCurrentGameScore());
    }

    @Test
    @Parameters({
            "4, 4",
            "5, 5",
            "15, 15",
            "26, 26"
    })
    public void checkForDeuceSituationInGame(int firstPlayerPoints,int secondPlayerPoints) {
        prepareScoreCard(firstPlayerPoints,secondPlayerPoints);

        Assert.assertEquals(TennisConstants.SCORE_DEUCE,tennisGame.getCurrentGameScore());
    }

    @Test
    @Parameters({
            "4, 5",
            "14, 15",
            "27, 28"
    })
    public void checkForAdvantageSituationForPlayerTwo(int firstPlayerPoints,int secondPlayerPoints) {
        prepareScoreCard(firstPlayerPoints,secondPlayerPoints);

        Assert.assertEquals(TennisConstants.SCORE_ADVANTAGE+TennisConstants.COLON+NAME_OF_SECOND_PLAYER,tennisGame.getCurrentGameScore());
    }

    @Test
    @Parameters({
            "5, 4",
            "15, 14",
            "22, 21"
    })
    public void checkForAdvantageSituationForFirstPlayer(int firstPlayerPoints,int secondPlayerPoints) {
        prepareScoreCard(firstPlayerPoints,secondPlayerPoints);

        Assert.assertEquals(TennisConstants.SCORE_ADVANTAGE+TennisConstants.COLON+NAME_OF_FIRST_PLAYER,tennisGame.getCurrentGameScore());
    }

    @Test
    @Parameters({
            "5, 3",
            "8, 6",
            "15, 13",
            "22, 20"
    })
    public void shouldReturnFirstPlayerAsWinnerIfFirstPlayerScoresWinningPoint(int firstPlayerPoints,int secondPlayerPoints) {
        prepareScoreCard(firstPlayerPoints,secondPlayerPoints);

        Assert.assertEquals(TennisConstants.SCORE_WINS+TennisConstants.COLON+NAME_OF_FIRST_PLAYER,tennisGame.getCurrentGameScore());
    }

    private void prepareScoreCard(int firstPlayerPoints, int secondPlayerPoints) {
        for(int counter=0; counter<firstPlayerPoints; counter++)
            tennisGame.increaseAPointForPlayer(NAME_OF_FIRST_PLAYER);
        for(int counter=0; counter<secondPlayerPoints; counter++)
            tennisGame.increaseAPointForPlayer(NAME_OF_SECOND_PLAYER);
    }
}
