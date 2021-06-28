/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 2
/*  Date: Jun 8, 2021
/* ********************************************************************/

package ws02_03;

public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws ShapeException {
        if (a + b > 0 && b > 0 && c > 0 && a + b > c && b + c > a && a + b > b) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new ShapeException("Invalid side(s)!");
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) throws ShapeException {
        if (a > 0) {
            this.a = a;
        } else {
            throw new ShapeException("Invalid side(s)!");
        }
    }

    public double getB() {
        return b;
    }

    public void setB(double b) throws ShapeException {
        if (b > 0) {
            this.b = b;
        } else {
            throw new ShapeException("Invalid side(s)!");
        }
    }

    public double getC() {
        return c;
    }

    public void setC(double c) throws ShapeException {
        if (c > 0) {
            this.c = c;
        } else {
            throw new ShapeException("Invalid side(s)!");
        }
    }

    @Override
    public double getPerimeter() {
        return getA() + getB() + getC();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {s1=" + getA() + ", s2=" + getB() + ", s3=" + getC() + "} perimeter = "
                + String.format("%g", getPerimeter());
    }
}