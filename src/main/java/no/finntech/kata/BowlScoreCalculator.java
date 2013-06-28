package no.finntech.kata;

import java.util.List;

public class BowlScoreCalculator {
    public int calculateScore(List<BowlingFrame> frames) {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            if ( i < 10 && frames.get(i).isSpare() ) {
                score += getSparePoints(frames, i);
            } else if ( i < 10 && frames.get(i).isStrike()) {
                score += getStrikePoints(frames, i);
            }
            score += frames.get(i).getTotal();
        }
        return score;
    }

    private int getStrikePoints(List<BowlingFrame> frames, int i) {
        return frames.get(i+1).getTotal();
    }

    private int getSparePoints(List<BowlingFrame> frames, int i) {
        return frames.get(i+1).getFirst();
    }
}
