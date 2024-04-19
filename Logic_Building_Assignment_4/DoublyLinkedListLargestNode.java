import java.util.Scanner;

class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedListLargestNode {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public int findLargest() {
        if (head == null) {
            System.out.println("Doubly Linked List is empty.");
            return Integer.MIN_VALUE;
        }
        int max = head.data;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    public static void main(String[] args) {
        DoublyLinkedListLargestNode dll = new DoublyLinkedListLargestNode();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            dll.insert(data);
        }
        scanner.close();

        int largest = dll.findLargest();
        if (largest == Integer.MIN_VALUE) {
            System.out.println("Doubly Linked List is empty.");
        } else {
            System.out.println("Largest node in Doubly Linked List: " + largest);
        }
    }
}
