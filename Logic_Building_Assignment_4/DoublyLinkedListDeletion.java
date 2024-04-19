import java.util.Scanner;

class Node1 {
    int data;
    Node1 prev;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedListDeletion {
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

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node with key " + key + " not found. Deletion failed.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        System.out.println("Node with key " + key + " deleted successfully.");
    }

    public void printList() {
        Node temp = head;
        System.out.println("Doubly Linked List:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedListDeletion dll = new DoublyLinkedListDeletion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            dll.insert(data);
        }

        System.out.println("Enter the key to delete:");
        int key = scanner.nextInt();
        scanner.close();

        dll.delete(key);
        dll.printList();
    }
}
