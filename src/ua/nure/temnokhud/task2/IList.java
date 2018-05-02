package ua.nure.temnokhud.task2;

interface IList<E> extends java.lang.Iterable<E> {
    void add(E el);

    void addAll(IList<? extends E> list);

    void clear();

    boolean contains(E el);

    E get(int index);

    int indexOf(E el);

    E remove(int index);

    boolean remove(E el);

    int size();
}

