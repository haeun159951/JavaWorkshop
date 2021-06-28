/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 2
/*  Date: Jun 8, 2021
/* ********************************************************************/

package ws02_03;

public class Circle implements Shape {

    private double radius;

    // better not to call setter in the constructor
    public Circle(double radius) throws ShapeException {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new ShapeException("Invalid radius!");
        }
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
        return getClass().getSimpleName() + " {r=" + getRadius() + "} perimeter = " + String.format("%g", getPerimeter());
    }
}