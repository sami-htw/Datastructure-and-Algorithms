package stack.stackAsArray;


public class StackAsArray {

    int[] stackBuffer;
    int size;
    int top;

    public StackAsArray(int size) {
        stackBuffer = new int[size];
        this.size = size;
        this.top = -1;
    }


    public static void main(String[] args) {
        StackAsArray stack = new StackAsArray(10);
        stack.pop();
        System.out.println("###########");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("###########");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("###########");
        System.out.println("Actual top element: " + stack.peek());

    }


    void push(int element) {
        if (!isFull()) {
            top++;
            stackBuffer[top] = element;
            System.out.println("Pushed element:" + element);
        } else {
            System.out.println("Stack is full !");
        }
    }

    int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("Popped element :" + stackBuffer[returnedTop]);
            return stackBuffer[returnedTop];

        } else {
            System.out.println("Stack is empty !");
            return -1;
        }

    }

    int peek() {
        if (!isEmpty())
            return stackBuffer[top];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    boolean isFull() {
        return (size - 1 == top);
    }

    boolean isEmpty() {
        return (top == -1);
    }


}



