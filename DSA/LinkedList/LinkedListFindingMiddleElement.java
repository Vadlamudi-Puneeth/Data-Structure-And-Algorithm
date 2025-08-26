import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListFindingMiddleElement{

    public static void middleElement(Node head){
        
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node temp = slow;
        System.out.println(temp.data);

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        Node head = null;
        Node temp = null;

        for(int i = 0;i < n; i++){
            int data = sc.nextInt();
            Node newNode = new Node(data);

            if(head == null){
                head = temp = newNode;
            }else{
                temp.next = newNode;
                temp = newNode;
            }

        }

      middleElement(head);

        // System.out.println(mid.data);

        Node top = head;
        while(top != null){
            System.out.print(top.data + " ");
            top = top.next;
        }

    }
}