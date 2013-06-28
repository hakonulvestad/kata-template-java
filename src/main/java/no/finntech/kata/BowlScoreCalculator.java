package no.finntech.kata;

import java.util.List;

public class BowlScoreCalculator {
    public int calculateScore(List<BowlingFrame> frames) {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            if ( i < 10 && frames.get(i).isSpare() ) {
                score += frames.get(i+1).getFirst();
            }
            score += frames.get(i).getFirst();
            score += frames.get(i).getSecond();
        }
        return score;
    }
}
