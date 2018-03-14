package ua.nure.temnokhud.task2;

public class MyList implements ListInterface {

    public static void main(String... args) {
        MyList list = new MyList();
        list.add("hi");
        list.add("hello");
        list.add("hola");
        MyList cloneList = new MyList();
        cloneList.add("bye");
        cloneList.add("have a nice day");
        cloneList.add("poka");
        System.out.println("List 1: ");
        list.print();
        System.out.println("List 2: ");
        cloneList.print();
        list.addAll(cloneList);
        System.out.println("Merged list 1: ");
        list.print();
        cloneList.clear();
        System.out.println("Empty list 2: ");
        cloneList.print();
        System.out.println("List 1 contains 'bye': ");
        System.out.println(list.contains("bye"));
        System.out.println("List 1 contains 'bie': ");
        System.out.println(list.contains("bie"));
        System.out.println("List 1 - 1st element: ");
        System.out.println(list.get(1));
        System.out.println("List 1 - index of 'hola': ");
        System.out.println(list.indexOf("hola"));
        System.out.println("List 1 - removed 'hola': ");
        System.out.println(list.remove("hola"));
        System.out.println("List 1: ");
        list.print();
        System.out.println("List 1 - 1st element: ");
        System.out.println(list.remove(0));
        System.out.println("List 1 - size: ");
        System.out.println(list.size());
        System.out.println("Iterator: ");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    Object[] values;

    public MyList() {
        values = new Object[0];
    }

    public void add(Object newObject) {
        Object[] newValues = new Object[values.length + 1];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        newValues[values.length] = newObject;
        values = newValues;
    }
    public void addAll(ListInterface list) {
        Object[] newValues = new Object[values.length + list.size()];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        for (int i = values.length; i < values.length + list.size(); i++) {
            newValues[i] = list.get(i - values.length);
        }
        values = newValues;
    }
    public void clear() {
        values = new Object[0];
    }
    public void print() {
        System.out.println(toString());
    }
    public boolean contains(Object object) {
        for(int i = 0; i < values.length; i++) {
            if(object.equals(values[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean remove(Object object) {
        boolean isRemoved = false;
        int index = values.length;
        Object[] newValues = new Object[values.length - 1];

        for(int i = 0; i < values.length; i++) {
            if(object.equals(values[i])) {
                index = i;
                isRemoved = true;
            }
        }
        if(!isRemoved) { return false; }

        for(int i = 0; i < values.length - 1; i++) {
            if(i < index) {
                newValues[i] = values[i];
            } else {
                newValues[i] = values[i + 1];
            }
        }
        return isRemoved;
    }
    public Object get(int index) {
        return values[index];
    }
    public Object remove(int index) {
        try {
            Object result = values[index];
            Object[] newValues = new Object[values.length - 1];
            for(int i = 0; i < values.length - 1; i++) {
                if(i < index) {
                    newValues[i] = values[i];
                } else {
                    newValues[i] = values[i + 1];
                }
            }
            return result;
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }
    public int indexOf(Object object) {
        for(int i = 0; i < values.length; i++) {
            if(object.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }
    public int size() {
        return values.length;
    }
    public Iterator iterator() {
        return new Iterator() {
            int index = 0;
            public boolean hasNext() {
                return index != values.length;
            }
            public Object next() {
                return values[index++];
            }
            public void remove() {
                MyList.this.remove(index);
            }
        };
    }

    public String toString() {
        return java.util.Arrays.toString(values);
    }
}