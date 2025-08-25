import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCreation {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of an element");
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

        Node top = head;

        while(top != null){
            System.out.print(top.data + " ");
            top = top.next;
        }

    }
}
