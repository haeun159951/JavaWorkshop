package ws06;

public class Parallelogram extends Rectangle {
    public Parallelogram(double width, double height) throws ShapeException {
        super(width, height);
    }

    @Override
    public String toString() {
        return "Parallelogram {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + String.format("%g", getPerimeter());
    }
}
