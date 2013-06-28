package no.finntech.kata;

import java.util.List;

public class BowlScoreCalculator {
    public int calculateScore(List<BowlingFrame> frames) {
        int score = 0;
        for (BowlingFrame frame : frames) {
            score += frame.getFirst();
            score += frame.getSecond();
        }
        return score;
    }
}
