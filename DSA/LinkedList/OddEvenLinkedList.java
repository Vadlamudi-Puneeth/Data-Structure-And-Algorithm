import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class OddEvenLinkedList {

    public static Node ListCreation(Node head) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node temp = null;

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newNode = new Node(data);

            if (head == null) {
                head = temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        return head;
    }

    public static Node ListOddEven(Node head2) {
        if (head2 == null) return null;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node curr = head2;
        int count = 1; 

        while (curr != null) {
            if (count % 2 != 0) {  
                if (oddHead == null) {
                    oddHead = oddTail = new Node(curr.data);
                } else {
                    oddTail.next = new Node(curr.data);
                    oddTail = oddTail.next;
                }
            } else {  
                if (evenHead == null) {
                    evenHead = evenTail = new Node(curr.data);
                } else {
                    evenTail.next = new Node(curr.data);
                    evenTail = evenTail.next;
                }
            }
            curr = curr.next;
            count++;
        }

        if (oddTail != null) {
            oddTail.next = evenHead;
        }

        return oddHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = ListCreation(head);

        Node newHead = ListOddEven(head);

        printList(newHead);
    }
}
