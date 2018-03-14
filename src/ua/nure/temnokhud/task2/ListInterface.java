package ua.nure.temnokhud.task2;

public interface ListInterface extends java.lang.Iterable<Object> {
    void add(Object el);
    void addAll(ListInterface list);
    void clear();
    boolean contains(Object el);
    Object get(int index);
    int indexOf(Object el);
    Object remove(int index);
    boolean remove(Object el);
    int size();
}

