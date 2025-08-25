import java.util.*;

class Node{
    
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

}

public class LinkedListReversal {

    public static Node reversal(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;   
            curr.next = prev;   
            prev = curr;        
            curr = next; 
        }

        return prev;

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

        head = reversal(head);

        Node top = head;
        while(top != null){
            System.out.print(top.data + " ");
            top = top.next;
        }
        
    }
}
