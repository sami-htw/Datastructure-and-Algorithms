package quque;

public class Queue<T> {

    private Node first = null;
    private Node last = null;

    public static void main(String[] args) {
        // first in first out (FIFO)
        Queue<String> queue = new Queue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        System.out.println("first element: " + queue.dequeue());
        System.out.println("second element: " + queue.dequeue());
        System.out.println("third element: " + queue.dequeue());

    }


    public void enqueue(T data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public T dequeue() {
        T value = (T) first.data;
        first = first.next;
        return value;

    }

}

class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
