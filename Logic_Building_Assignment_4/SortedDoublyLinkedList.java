import java.util.Scanner;

class SDLLNode {
    int data;
    SDLLNode prev;
    SDLLNode next;

    SDLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class SortedDoublyLinkedList {
    Node head;

    public void insertSorted(int data) {
        Node newNode = new Node(data);
        if (head == null || data <= head.data) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedDoublyLinkedList sortedDLL = new SortedDoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        System.out.println("Enter sorted elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            sortedDLL.insertSorted(data);
        }
        System.out.println("Sorted Doubly Linked List:");
        sortedDLL.display();
        scanner.close();
    }
}
