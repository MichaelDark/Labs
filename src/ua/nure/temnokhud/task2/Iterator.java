package ua.nure.temnokhud.task2;

public interface Iterator extends java.util.Iterator<Object> {
    boolean hasNext();
    Object next();
    void remove();
}
