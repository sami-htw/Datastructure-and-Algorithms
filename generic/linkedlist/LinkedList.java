package generic.linkedlist;

public class LinkedList <T>{
    ListNode head = null;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList();

        linkedList1.appendNode(10);
        linkedList1.appendNode(11);
        linkedList1.appendNode(12);

        linkedList1.display();
        System.out.println("########");
        System.out.println("Check if number 8 is there ? ");
        linkedList1.removeNode(8);
        linkedList1.removeNode(10);
        System.out.println("Display After removing: ");

        linkedList1.display();

        LinkedList<String> linkedList2 = new LinkedList();
        linkedList2.appendNode("first");
        linkedList2.appendNode("second");
        linkedList2.appendNode("third");
        System.out.println("String elements : ");
        linkedList2.display();
    }

    void appendNode(T data) {

        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);

    }

    void prependNode(T data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }


    void removeNode(T data) {

        if (head == null) {
            throw new IllegalStateException("List is empty !");
        }
        if (head.data == data) {
            head = head.next;
            return;
        }


        ListNode current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;

        }
        System.out.println("Element not exist");


    }


    void display() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }



}


class ListNode<T>{
    T data;
    ListNode next;

    public ListNode(T data) {
        this.data = data;
        next = null;
    }


}


