package no.finntech.kata;

public class FrameBuilder {

    private static BowlingFrame firstFrame;
    private BowlingFrame frame;

    public FrameBuilder frame(int first, int second) {
        if(frame == null) {
            frame = new BowlingFrame(first, second);
            firstFrame = frame;
        } else {
            frame.setNext(new BowlingFrame(first, second));
            frame = frame.getNext();
        }

        return this;
    }

    public BowlingFrame build() {
        return this.firstFrame;
    }
}
