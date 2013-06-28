package no.finntech.kata;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlScoreCalculatorTest {

    private BowlScoreCalculator bowlScoreCalculator = new BowlScoreCalculator();

    @Test
    public void all1sOnFirstThrow() {
        List<BowlingFrame> frames = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            frames.add(new BowlingFrame(1, 0));

        }
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(10));
    }

    @Test
    public void all1sOnSecondThrow() throws Exception {
        List<BowlingFrame> frames = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            frames.add(new BowlingFrame(0, 1));

        }
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(10));
    }

    @Test
    public void twoFramesSpareFirst() throws Exception {
        List<BowlingFrame> frames = new ArrayList<>();
        frames.add(new BowlingFrame(5, 5));
        frames.add(new BowlingFrame(2, 2));
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(16));
    }

    @Test
    public void twoFramesStrikeFirst() throws Exception {
        List<BowlingFrame> frames = new ArrayList<>();
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(2, 2));
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(18));
    }

    @Test
    public void threeFramesStrikeSpear2() throws Exception {
        List<BowlingFrame> frames = new ArrayList<>();
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(2, 8));
        frames.add(new BowlingFrame(2, 2));
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(36));
    }

    @Test
    public void threeFramesStrikeStrike2() throws Exception {
        List<BowlingFrame> frames = new ArrayList<>();
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(2, 2));
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(42));
    }

    @Test
    public void twelveFramesAllStrikes() throws Exception {
        List<BowlingFrame> frames = new ArrayList<>();
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        frames.add(new BowlingFrame(10, 0));
        int score = bowlScoreCalculator.calculateScore(frames);
        assertThat(score, is(300));
    }

}
