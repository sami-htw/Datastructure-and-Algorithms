package stack.stackAsList;

public class StackAsList {

    private Node top;

    public static void main(String[] args) {
        StackAsList stackAsList = new StackAsList();
        stackAsList.push(1);
        stackAsList.push(2);
        stackAsList.push(3);
        stackAsList.push(4);
        System.out.println("popped element: " + stackAsList.pop());
        System.out.println("popped element: " + stackAsList.pop());
        stackAsList.push(22);
        stackAsList.push(23);
        stackAsList.push(24);
        System.out.println("Display elements: ");

        stackAsList.display();

    }

    void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty!");
        }
        Node n = top;
        top = top.next;
        return n.data;
    }

    void display() {
        Node n = top;
        while (n != null) {
            System.out.print(n.data + "  ");
            n = n.next;
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
