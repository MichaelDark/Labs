package ua.nure.temnokhud.task2;

public class Circle {

    public static void main(String... args) {
        Circle circle = new Circle(5.4, 3.7, 7);
        circle.print();
        circle.move(5, 5);
        circle.print();
        circle.isInside(5, 5);
        circle.isInside(25, 5);
        circle.isInside(new Circle(9, 9, 3));
        circle.isInside(new Circle(5, 5, 20));
    }

    private double x;
    private double y;
    private double r;

    public Circle () {
        x = 0;
        y = 0;
        r = 0;
    }
    public Circle (double X, double Y, double Radius) {
        x = X;
        y = Y;
        r = Radius;
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
    public void setRadius(double NewRadius) {
        r = NewRadius;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public boolean isInside(double X, double Y) {
        boolean inside = Math.pow(x - X, 2) + Math.pow(y - Y, 2) <= r * r;

        System.out.printf("Dot (%5.2f, %5.2f) is inside: %b", X, Y, inside);
        System.out.println();
        return inside;
    }

    public boolean isInside(Circle circle) {
        double distanceBetweenCenters =
            Math.sqrt(Math.pow(x - circle.getX(), 2) + Math.pow(y - circle.getY(), 2));
        boolean inside = distanceBetweenCenters + circle.getR() <= r;

        System.out.printf("Circle (%5.2f, %5.2f, %5.2f) is inside: %b",
                circle.getX(), circle.getY(), circle.getR(), inside);
        System.out.println();
        return inside;
    }

    public void print() {
        System.out.println("== Circle info:");
        System.out.println("   Center: (" + x + ", " + y + ")");
        System.out.println("   Radius: " + r);
        System.out.println();
    }
}
