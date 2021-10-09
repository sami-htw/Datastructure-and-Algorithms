package generic.queue;

import java.util.ArrayList;


/**
 * Queue generic implementation
 */
public class Queue<T> {
    private int front = -1, rear = -1;

    ArrayList<T> buffer = new ArrayList<>();


    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        System.out.println("Integer Queue after enqueue of 3 elements:\n" + integerQueue);

        System.out.println("Front : " + integerQueue.peekFrontElement() + " rear : " + integerQueue.peekRearElement());


        integerQueue.dequeue();
        System.out.println("Integer Queue after dequeue :\n" + integerQueue);


        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("first");
        stringQueue.enqueue("second");
        stringQueue.enqueue("third");
        System.out.println(
                "\nstring Queue after enqueue of 3 elements:\n" + stringQueue);
        System.out.println("Front : " + stringQueue.peekFrontElement() + " , rear : " + stringQueue.peekRearElement());

        System.out.println("checking if Queue is empty :" + stringQueue.isEmpty());
    }


    T peekFrontElement() {
        if (front == -1) {
            return null;
        }
        return buffer.get(front);
    }


    T peekRearElement() {
        if (rear == -1) {
            return null;
        }
        return buffer.get(rear);
    }


    void enqueue(T value) {

        if (isEmpty()) {
            front = 0;
            rear = 0;
            buffer.add(value);
        } else {
            front++;
            if (buffer.size() > front) {
                buffer.set(front, value);

            } else {
                buffer.add(value);
            }
        }
    }


    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            rear++;
        }
    }


    @Override
    public String toString() {
        if (this.isEmpty())
            return "";

        String Ans = "";

        for (int i = rear; i < front; i++) {
            Ans += String.valueOf(buffer.get(i)) + " --> ";
        }

        Ans += String.valueOf(buffer.get(front));

        return Ans;
    }

    boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

}


