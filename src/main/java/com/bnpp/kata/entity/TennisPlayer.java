package com.bnpp.kata.entity;

public class TennisPlayer {
    private String nameOfPlayer;
    private int pointsScoredByPlayer;


    public TennisPlayer(String nameOfPlayerOne) {
        this.nameOfPlayer = nameOfPlayerOne;
    }

    public String getNameOfPlayer() {
        return nameOfPlayer;
    }

    public int getPointsScoredByPlayer() {
        return pointsScoredByPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }

    public void setPointsScoredByPlayer(int pointsScoredByPlayer) {
        this.pointsScoredByPlayer = pointsScoredByPlayer;
    }
}
