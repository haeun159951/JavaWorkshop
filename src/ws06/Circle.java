package ws06;


public class Circle implements Shape{

    private double radius;
    private Area area = () -> radius * radius * Math.PI;

    public Circle(double radius) throws ShapeException{
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws ShapeException {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new ShapeException("Invalid radius!");
        }
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public String toString() {
        return "Circle {r=" + getRadius() + "} perimeter = " + String.format("%g", getPerimeter())+ " Area = " + String.format("%g", area.area());

    }
}