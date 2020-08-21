package com.bnpp.kata;

public enum TennisScoreEnum {
    LOVE("Love",0),FIFTEEN("Fifteen",1),THIRTY("Thirty",2),FORTY("Forty",3);

    String score;
    int point;

    TennisScoreEnum(String score, int point) {
        this.score=score;
        this.point=point;
    }

    public static TennisScoreEnum fromScore(int point) {
        if(point<0) throw new IllegalArgumentException("Invalid Tennis Point");
        for(TennisScoreEnum tennisScore:TennisScoreEnum.values())
        {
            if(tennisScore.point==point) return tennisScore;
        }
        return null;
    }
}
