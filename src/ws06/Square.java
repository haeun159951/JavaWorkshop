package ws06;

public class Square extends Rectangle{
    double leg;

    public Square(double leg) throws ShapeException{
        super(leg, leg);
    }

    @Override
    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public String toString() {
        return "Square {s=" + getWidth() + "} perimeter = " + String.format("%g", getPerimeter()) + " Area = " + String.format("%g", area.area());
    }

}