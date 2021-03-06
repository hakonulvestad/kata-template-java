package no.finntech.kata;

import java.util.List;

public class BowlScoreCalculator {

    public static final int MAX_NO_FRAMES = 10;

    public int calculateScore(List<BowlingFrame> frames) {
        int score = 0;
        for (int i = 0; i < frames.size() && i < MAX_NO_FRAMES; i++) {
            if ( i < frames.size() && frames.get(i).isSpare() ) {
                score += getSparePoints(frames, i);
                score += frames.get(i).getTotal();
            } else if ( i < frames.size() && frames.get(i).isStrike()) {
                score += getStrikePoints(frames, i, 2);
            } else {
                score += frames.get(i).getTotal();
            }
        }
        return score;
    }

    private int getStrikePoints(List<BowlingFrame> frames, int i, int count) {
        int total = 0;

        if (count > 0 && i < frames.size()-1){
            total += getStrikePoints(frames, i + 1, count - 1);
        }
        if (i < frames.size()) {
            total += frames.get(i).getTotal();
        }

        return total;

    }

    private int getSparePoints(List<BowlingFrame> frames, int i) {
        return frames.get(i+1).getFirst();
    }

    public int calculateScore(BowlingFrame firstFrame) {
        int total = 0;
        int counter = 0;
        BowlingFrame currentFrame = firstFrame;
        while(currentFrame != null && counter < 10) {
            total += currentFrame.getScore();
            currentFrame = currentFrame.getNext();
            counter++;
        }

        return total;
    }
}
