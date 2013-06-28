package no.finntech.kata;

public class BowlingFrame {

    private int first;
    private int second;

    private BowlingFrame next;

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

    public void setNext(BowlingFrame next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public BowlingFrame getNext() {
        return next;
    }

    public int getScore() {
        return getScore(3);
    }

    private int getScore(int counter) {
        int total = getTotal();
        if(isStrike() && hasNext() && counter > 1) {
            total += next.getScore(counter-1);
        } else if(isSpare() && hasNext()) {
           total += next.getFirst();
        }

        return total;
    }
}
