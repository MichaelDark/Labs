package ua.nure.temnokhud.task2;

import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.out;

public class List<E> implements IList<E>, Iterable<E> {

    public static void main(String... args) {
        out.println("~~~ list A B C");
        out.println("~~~ Result: [A, B, C]");
        IList<String> list = new List<>();
        list.add("A");
        list.add("B");
        list.add("C");
        out.println(list);

        out.println("~~~ list2: D E F");
        out.println("~~~ Result: [D, E, F]");
        IList<String> list2 = new List<>();
        list2.add("D");
        list2.add("E");
        list2.add("F");
        out.println(list2);

        out.println("~~~ list.addAll(list2)");
        out.println("~~~ Result: [A, B, C, D, E, F]");
        list.addAll(list2);
        out.println(list);

        out.println("~~~ list.add(C)");
        out.println("~~~ Result: [A, B, C, D, E, F, C]");
        list.add("C");
        out.println(list);

        out.println("~~~ list.clear()");
        out.println("~~~ Result: []");
        list.clear();
        out.println(list);

        out.println("~~~ list.addAll(list2)");
        out.println("~~~ Result: [D, E, F]");
        list.addAll(list2);
        out.println(list);

        out.println("~~~ list.contains(E)");
        out.println("~~~ Result: true");
        out.println(list.contains("E"));

        out.println("~~~ list.contains(С)");
        out.println("~~~ Result: false");
        out.println(list.contains("C"));

        out.println("~~~ list.indexOf(D)");
        out.println("~~~ Result: 0");
        out.println(list.indexOf("D"));

        out.println("~~~ list.get(2)");
        out.println("~~~ Result: F");
        out.println(list.get(2));

        out.println("~~~ list.indexOf(F)");
        out.println("~~~ Result: 2");
        out.println(list.indexOf("F"));

        out.println("~~~ list.size()");
        out.println("~~~ Result: 3");
        out.println(list.size());

        out.println("~~~ list");
        out.println("~~~ Result: [D, E, F]");
        out.println(list);

        out.println("~~~ list.remove(1)");
        out.println("~~~ Result: [D, F]");
        list.remove(1);
        out.println(list);

        out.println("~~~ list.remove(F)");
        out.println("~~~ Result: [D]");
        list.remove("F");
        out.println(list);

        out.println("~~~ list.size()");
        out.println("~~~ Result: 1");
        out.println(list.size());

        out.println("~~~ list.addAll(list2)");
        out.println("~~~ Result: [D, D, E, F]");
        list.addAll(list2);
        out.println(list);

        out.println("~~~ foreach list");
        out.println("~~~ Result: D D E F");
        for (String el : list) {
            out.print(el + " ");
        }
        out.println();

        out.println("~~~ Iterator it = list.iterator()");
        Iterator<String> it = list.iterator();

        out.println("~~~ it.next()");
        out.println("~~~ Result: D");
        out.println(it.next());

        out.println("~~~ it.next()");
        out.println("~~~ Result: D");
        out.println(it.next());

        out.println("~~~ it.remove()");
        out.println("~~~ Result: [D, E, F]");
        it.remove();
        out.println(list);

        out.println("~~~ it.next()");
        out.println("~~~ Result: E");
        out.println(it.next());

        out.println("~~~ it.remove()");
        out.println("~~~ Result: [D, F]");
        it.remove();
        out.println(list);

        out.println("~~~ it.next()");
        out.println("~~~ Result: F");
        out.println(it.next());

        out.println("~~~ it.remove()");
        out.println("~~~ Result: [D]");
        it.remove();
        out.println(list);

        out.println("~~~ list.remove(D)");
        out.println("~~~ Result: []");
        list.remove("D");
        out.println(list);

        out.println("~~~ list.addAll(list2)");
        out.println("~~~ Result: [D, E, F]");
        list.addAll(list2);
        out.println(list);

        out.println("~~~ foreach list");
        out.println("~~~ Result: D E F ");
        for (String el : list) {
            out.print(el + " ");
        }
        out.println();
    }

    private static final int START_SIZE = 3;

    private Object[] container;
    private int last;

    public List() {
        container = new Object[START_SIZE];
        last = -1;
    }

    public void add(E el) {
        if (last == container.length - 1) {
            container = Arrays.copyOf(container, container.length * 2);
        }

        last++;
        container[last] = el;
    }

    public void addAll(IList<? extends E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public void clear() {
        last = -1;
    }

    public boolean contains(E el) {
        return indexOf(el) != -1;
    }

    public E get(int index) {
        if (index > last) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return (E) container[index];
    }

    public int indexOf(Object el) {
        for (int i = 0; i <= last; i++) {
            if (container[i].equals(el)) {
                return i;
            }
        }

        return -1;
    }

    public E remove(int index) {
        if (index > last) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        E removed = get(index);

        for (int i = index + 1; i <= last; i++) {
            container[i - 1] = container[i];
        }

        last--;

        return removed;
    }

    public boolean remove(Object el) {
        int index = indexOf(el);

        if (index == -1) {
            return false;
        }

        remove(index);

        return true;
    }

    public int size() {
        return last + 1;
    }

    // End List implementation

    // Iterable implementation

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;
            private boolean canRemove = false;

            @Override
            public boolean hasNext() {
                return currentIndex <= List.this.last;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IllegalStateException();
                }

                canRemove = true;
                return (E) container[currentIndex++];
            }

            @Override
            public void remove() {
                if (!canRemove) {
                    throw new IllegalStateException();
                }

                List.this.remove(--currentIndex);
                canRemove = false;
            }
        };
    }

    // End Iterable implementation

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i <= last; i++) {
            sb.append(container[i]);
            if (i < last) {
                sb.append(", ");
            }
        }
        sb.append(" }");

        return sb.toString();
    }
}