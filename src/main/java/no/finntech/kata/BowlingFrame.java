package no.finntech.kata;

public class BowlingFrame {

    private int first;
    private int second;

    public BowlingFrame(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean isSpare() {
          return first+second == 10 && first != 10;
    }

    public boolean isStrike() {
        return first == 10;
    }

    public int getTotal() {
        return first+second;
    }
}
