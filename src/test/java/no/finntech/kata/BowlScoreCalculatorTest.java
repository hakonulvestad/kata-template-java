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

}
