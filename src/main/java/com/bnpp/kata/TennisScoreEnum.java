package com.bnpp.kata;

import com.bnpp.kata.constants.TennisConstants;
import com.bnpp.kata.exception.TennisException;

public enum TennisScoreEnum {
    LOVE("Love",0),FIFTEEN("Fifteen",1),THIRTY("Thirty",2),FORTY("Forty",3);

    String score;
    int point;

    TennisScoreEnum(String score, int point) {
        this.score=score;
        this.point=point;
    }

    public static TennisScoreEnum fromScore(int point) {
        if(point< TennisConstants.ZERO_POINT || point>TennisConstants.THREE_POINT) throw new TennisException("Invalid Tennis Point");
        for(TennisScoreEnum tennisScore:TennisScoreEnum.values())
        {
            if(tennisScore.point==point) return tennisScore;
        }
        return null;
    }
}
