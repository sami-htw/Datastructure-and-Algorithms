package queue.queueAsArray;

public class QueueImpl {
    private int[] queue;
    private int rear;
    private int front;
    private int capacity;
    private int count;

    public QueueImpl(int size) {
        queue = new int[size];
        capacity = size;
        rear = -1;
        front = 0;
        count = 0;
    }

    public static void main(String[] args) {

        QueueImpl obj = new QueueImpl(5);
        obj.enqueue(22);
        obj.enqueue(23);
        obj.enqueue(24);
        obj.enqueue(25);
        obj.enqueue(26);
        System.out.println("The front element is : " + obj.peek());
        obj.dequeue();
        System.out.println("The front element is : " + obj.peek());
        System.out.println("The queue size is : " + obj.size());
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();


        if (obj.isEmpty()) {
            System.out.println("Queue state : EMPTY");
        } else {
            System.out.println("Queue state : NOT-EMPTY");
        }

    }


    void enqueue(int element) {
        if (isFull()) {
            System.out.println("Overflow !, Queue is full ");
            System.exit(1);
        }
        System.out.println("insert : " + element);
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        count++;

    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            System.exit(1);
        }
        System.out.println("Removing " + queue[front]);

        front = (front + 1) % capacity;
        count--;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            System.exit(1);
        }
        return queue[front];
    }


    private int size() {
        return count;
    }

    private boolean isEmpty() {
        return (size() == 0);
    }

    private boolean isFull() {
        return (size() == capacity);
    }


}
