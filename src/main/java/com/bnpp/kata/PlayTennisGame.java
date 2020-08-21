package com.bnpp.kata;

import java.util.Scanner;

public class PlayTennisGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("\nGame Started: Kindly provide the name of two players. \n");
        System.out.println("Player 1 name :");
        String firstPlayer = scanner.nextLine();

        System.out.println("Player 2 name :");
        String secondPlayer = scanner.nextLine();

        System.out.println("Game Ended");
    }
}
