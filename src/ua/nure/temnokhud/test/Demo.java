package ua.nure.temnokhud.test;

public class Demo {

    public static void main(String... args) {
        foo f1 = new foo();
        bar b1 = new bar();
        bar b2 = new foo();

        f1.m();
        b1.m();
        b2.m();

        f1.n();
        b1.n();
        b2.n();

        f1.o();
    }
}
