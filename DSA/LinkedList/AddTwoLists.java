import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddTwoLists {

    public static void ListAdding(Node list1, Node list2) {
        Node head = null;
        Node tail = null;

        int carry = 0;
        System.out.println("----------------");

        while (list1 != null || list2 != null || carry > 0) {
            int val1 = 0;
            int val2 = 0;
            
            if(list1 != null){
                val1 = list1.data;
            }
            if(list2 != null){
                val2 = list2.data;
            }

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int mod = sum % 10;

            Node newNode = new Node(mod);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }

        Node top = head;
        while (top != null) {
            System.out.print(top.data + " ");
            top = top.next;
        }
    }

    public static Node ListCreation(Node head) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of an element");
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

    public static void main(String args[]) {
        Node head1 = null;
        Node head2 = null;
        Node list1 = null;
        Node list2 = null;
        head1 = ListCreation(list1);
        head2 = ListCreation(list2);

        ListAdding(head1, head2);
    }
}
