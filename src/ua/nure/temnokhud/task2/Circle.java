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

    public Circle(double startX, double startY, double radius) {
        x = startX;
        y = startY;
        r = radius;
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

    public boolean isInside(double X, double Y) {
        return Math.pow(x - X, 2) + Math.pow(y - Y, 2) <= r * r;
    }

    public boolean isInside(Circle circle) {
        double distanceBetweenCenters =
                Math.sqrt(Math.pow(x - circle.x, 2) + Math.pow(y - circle.y, 2));
        return distanceBetweenCenters + circle.r <= r;
    }

    public String getInfo() {
        return "Circle (" + x + ", " + y + ", " + r + ")";
    }

    public void print() {
        out.println(getInfo());
    }
}
