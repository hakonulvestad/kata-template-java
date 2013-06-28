package no.finntech.kata;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlScoreCalculatorTest {

    private BowlScoreCalculator bowlScoreCalculator = new BowlScoreCalculator();

    @Test
    public void all1sOnFirstThrow() {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0)
                .frame(1, 0).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(10));
    }

    @Test
    public void all1sOnSecondThrow() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1)
                .frame(0, 1).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(10));
    }

    @Test
    public void twoFramesSpareFirst() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(5, 5)
                .frame(2, 2).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(16));
    }

    @Test
    public void twoFramesStrikeFirst() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(2, 2).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(18));
    }

    @Test
    public void threeFramesStrikeSpear2() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(2, 8)
                .frame(2, 2).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(38));
    }

    @Test
    public void threeFramesStrikeStrike2() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(10, 0)
                .frame(2, 2).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(42));
    }

    @Test
    public void twelveFramesAllStrikes() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(300));
    }

    @Test
    public void allStrikesSomethingElseLast() throws Exception {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(0, 9).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(288));
    }

    @Test
    public void allStrikesSpareLast() {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(8, 2).build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(290));
    }

    @Test
    public void SpareLastStrike() {
        BowlingFrame firstFrame = new FrameBuilder()
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(10, 0)
                .frame(2, 8)
                .frame(10, 0)
                .build();

        int score = bowlScoreCalculator.calculateScore(firstFrame);
        assertThat(score, is(290));
    }

}
