package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;

import java.util.Scanner;

public class PlayTennisGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static String firstPlayer="";
    private static String secondPlayer="";

    public static void main(String[] args) {
        boolean flag=true;
        while(flag) {
            System.out.println("Kindly enter two different players names to start the game.");
            System.out.print("Player 1 name : ");
            firstPlayer = scanner.nextLine().trim();

            System.out.print("Player 2 name : ");
            secondPlayer = scanner.nextLine().trim();

            if(isDifferentPlayerNames())
            {
                flag=false;
            }
        }

        if (isDifferentPlayerNames()) {

            TennisGame tennisGame = new TennisGame(firstPlayer, secondPlayer);
            boolean isGameEnded = false;
            String gameScore = tennisGame.getCurrentGameScore();
            System.out.println(gameScore);
            System.out.println("------------------------------");

            while (!isGameEnded) {
                System.out.print("Point won by player :");
                String inputPlayer = scanner.nextLine();

                if (validPlayerName(inputPlayer)) {
                    tennisGame.increaseAPointForPlayer(inputPlayer);

                    gameScore = tennisGame.getCurrentGameScore();
                    System.out.println(gameScore);
                    System.out.println("------------------------------");

                    isGameEnded = gameScore.contains(TennisConstants.SCORE_WINS);
                } else
                    System.out.println("Kindly enter correct player name.");
            }
            System.out.println("Game is now ended");
        }
        else
        {
            System.out.println("Player names cannot be same.");
        }
    }

    private static boolean isDifferentPlayerNames() {
        return isPlayerNamesNotNull() && !firstPlayer.equalsIgnoreCase(secondPlayer);
    }

    private static boolean isPlayerNamesNotNull() {
        return !(null == firstPlayer) && !("".equals(firstPlayer)) && !(null == secondPlayer) && !("".equals(secondPlayer));
    }

    private static boolean validPlayerName(String inputPlayer) {
        return isPlayerNamesNotNull() && (inputPlayer.equalsIgnoreCase(firstPlayer) || (inputPlayer.equalsIgnoreCase(secondPlayer)));
    }

}
