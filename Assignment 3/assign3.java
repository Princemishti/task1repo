

 interface MyList<T> {
    void add(T x);
    void insert(T x, int index);
    T get(int index);
    void delete(int index);
    int size();
    boolean isEmpty();
}

 class MyArrayList<T> implements MyList<T> {

    private Object[] data;
    private int size;
    private int capacity;

    public MyArrayList() {
        capacity = 1;
        size = 0;
        data = new Object[capacity];
    }

    private void resize() {
        capacity = capacity * 2;
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    @Override
    public void add(T x) {
        if (size == capacity) {
            resize();
        }
        data[size++] = x;
    }

    @Override
    public void insert(T x, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        if (size == capacity) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = x;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return (T) data[index];
    }

    @Override
    public void delete(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

 class MyLinkedList<T> implements MyList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void delete(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


public class Main {

    public static void printList(MyList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyList<Integer> list1 = new MyArrayList<>();
        MyList<String> list2 = new MyLinkedList<>();

        try {
            list1.add(10);
            list1.add(20);
            list1.insert(15, 1);
            printList(list1);

            list2.add("A");
            list2.add("B");
            list2.delete(0);
            printList(list2);

            // Force exception
            list1.get(10);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("State error: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}










