package generic.stack;

public class Stack<T> {

    private Node top = null;

    public static void main(String[] args) {
        // Last in first Out (LIFO)
        Stack stack = new Stack();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println("Top element: " + stack.pop());
        System.out.println("Top element: " + stack.pop());
        System.out.println("Display elements:");
        stack.display();
    }

    void push(T value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    T pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty !");
        }
        Node n = top;
        top = top.next;
        return (T) n.data;
    }

    void display() {
        Node n = top;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
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
