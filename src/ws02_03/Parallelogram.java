/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 2
/*  Date: Jun 8, 2021
/* ********************************************************************/

package ws02_03;

public class Parallelogram extends Rectangle {
    public Parallelogram(double width, double height) throws ShapeException {
        super(width, height);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ " {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + String.format("%g", getPerimeter());
    }
}