package tree;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Tree(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {

        Node root = new Node(6);
        Tree binaryTree = new Tree(root);
        root.insertNode(7);
        root.insertNode(8);
        root.insertNode(5);
        root.insertNode(3);
        root.insertNode(2);
        root.insertNode(9);
        System.out.println("Check if  number 1 inside the tree : " + root.contains(1));
        System.out.println("Tree elements : ");
        root.printInOrder();

        System.out.println("\nThe Tree contains (" + binaryTree.countNodes() + ") Nodes");
        System.out.println("The Depth of Tree : " + binaryTree.calculateDepth() + " level");

        System.out.println("Print the Tree in order : ");
        root.traverseTreeInOrder(root);

        Tree tree = new Tree();
        tree.root = new Node(12);
        tree.root.right = new Node(13);
        tree.root.right.right = new Node(14);
        tree.root.left = new Node(11);
        tree.root.left.left = new Node(10);
        System.out.println("\nSecond Binary tree : ");
        root.traverseTreeInOrder(tree.root);

    }

    public int countNodes() {
        return countNodes(root);
    }

    public int calculateDepth() {
        return calculateDepth(root);
    }

    private int countNodes(Node node) {
        int counter = 0;
        if (node != null) {
            counter = 1 + countNodes(node.left) + countNodes(node.right);
        }
        return counter;
    }

    private int calculateDepth(Node node) {
        int counter = 0;
        if (node != null && (node.left != null || node.right != null)) {
            counter = 1 + Math.max(calculateDepth(node.left), calculateDepth(node.right));
        }
        return counter;
    }


}


class Node {
    int data;
    Node right, left;

    public Node(int data) {
        this.data = data;
        right = left = null;
    }

    public void insertNode(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insertNode(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insertNode(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }

        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    public void traverseTreeInOrder(Node node) {
        if (node != null) {
            traverseTreeInOrder(node.left);
            System.out.print(node.data + " ");
            traverseTreeInOrder(node.right);
        }
    }

}