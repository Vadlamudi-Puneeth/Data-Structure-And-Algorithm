import java.util.*;

public class RotateList {

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

    public static Node rotateRight(Node head,int k){
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }


        Node temp = head;
        int len = 1;

        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        temp.next = head;

        int steps = len - (k % len);

        Node newTail = head;
        for(int i = 1;i < steps; i++){
            newTail = newTail.next;
        }

        Node newhead = newTail.next;
        newTail.next = null;

        return newhead;

    }

    public static void main(String[] args) {
        Node head = null;
        head = ListCreation(head); 
        
        Node right = rotateRight(head,2);

        Node temp = right;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
    }
}
