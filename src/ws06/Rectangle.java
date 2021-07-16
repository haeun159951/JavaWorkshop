package ws06;

public class Rectangle implements Shape {

    private double height;
    private double width;
    protected Area area = () -> getWidth() * getWidth();

    public Rectangle(double width, double height) throws ShapeException {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new ShapeException("Invalid side!");
        }
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ShapeException {
        if (height > 0) {
            this.height = height;
        }
        throw new ShapeException("Invalid side(s)!");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws ShapeException {
        if (width > 0) {
            this.width = width;
        }

        throw new ShapeException("Invalid side(s)!");
    }

    @Override
    public double getPerimeter() {
        return 2 * getHeight() + 2 * getWidth();
    }

    @Override
    public String toString() {
        return "Rectangle {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + String.format("%g", getPerimeter())
                + " Area = " + String.format("%g", area.area());
    }
}