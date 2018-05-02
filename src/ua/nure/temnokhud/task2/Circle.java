package ua.nure.temnokhud.task2;

import static java.lang.System.out;

class Circle {

    public static void main(String... args) {
        out.println("~~~ c");
        Circle c = new Circle(0, 0, 1);
        c.print();
        out.println("~~~ c.move(1, 1)");
        c.move(1, 1);
        c.print();
        out.println("~~~ c.isInside(1, 1)");
        out.println(c.isInside(1, 1));
        out.println("~~~ c.isInside(10, 1)");
        out.println(c.isInside(10, 1));
        out.println("~~~ c2");
        Circle c2 = new Circle(1, 1, 2);
        c2.print();
        out.println("~~~ c.isInside(c2)");
        out.println(c.isInside(c2));
        out.println("~~~ c2.isInside(c)");
        out.println(c2.isInside(c));

        out.println();
    }

    private double x;
    private double y;
    private double r;

    public Circle() {
        x = 0;
        y = 0;
        r = 1;
    }

    public Circle(double startX, double startY, double radius) {
        x = startX;
        y = startY;
        r = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void resize(double newRadius) {
        r = newRadius;
    }

    public boolean isInside(double pointX, double pointY) {
        double squareDistance = Math.pow(x - pointX, 2) + Math.pow(y - pointY, 2);
        double squareRadius = r * r;
        return squareDistance <= squareRadius;
    }

    public boolean isInside(Circle circle) {
        //double distanceBetweenCenters = Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
        double distanceBetweenCenters = Math.sqrt(Math.pow(x - circle.getX(), 2) + Math.pow(y - circle.getY(), 2));
        double radiusDifference = r - circle.r;
        //double radiusDifference = r - circle.getR();
        return distanceBetweenCenters <= radiusDifference;
    }

    public String getInfo() {
        return "Circle (" + x + ", " + y + ", " + r + ")";
    }

    public void print() {
        out.println(getInfo());
    }
}
