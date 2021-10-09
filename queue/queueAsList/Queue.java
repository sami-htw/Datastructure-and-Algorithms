package queue.queueAsList;

public class Queue {
    private Node front, rear;
    private int currentSize;

    public Queue() {
        this.front = null;
        this.rear = null;
        currentSize = 0;

    }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.dequeue();
        System.out.println("Is the Queue Empty ? " + q.isEmpty());
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);
        q.dequeue(); // 10 is removed
        System.out.println("Queue Front : " + q.front.data);
        System.out.println("Queue Rear : " + q.rear.data);
        System.out.println("Is the Queue Empty ? " + q.isEmpty());
    }

    boolean isEmpty() {
        return (currentSize == 0);
    }


    void enqueue(int value) {
        // Create a new linked-list node
        Node temp = new Node(value);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;

        currentSize++;

    }

    void dequeue() {
        // If queue is empty, return NULL.
        if (this.front == null) {
            return;
        }

        // Store previous front and move front one node ahead
        Node temp = this.front;
        this.front = this.front.next;


        // If front becomes NULL, then change rear also as NULL
        if (this.front == null) {
            this.rear = null;
            currentSize--;
        }

    }

}


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
