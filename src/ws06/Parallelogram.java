package ws06;

public class Parallelogram extends Rectangle {
    public Parallelogram(double height, double width) throws ShapeException {
        super(height, width);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Parallelogram {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + String.format("%g", getPerimeter());
    }
}
