/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 2
/*  Date: Jun 8, 2021
/* ********************************************************************/

package ws02_03;

public class Square extends Rectangle {
    double leg;

    public Square(double leg) throws ShapeException {
        super(leg, leg);
    }

    @Override
    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {s=" + getWidth() + "} perimeter = " + String.format("%g", getPerimeter());
    }
}