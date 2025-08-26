
import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MergeTwoSortedList {

    public static Node LinkedListCreation(Node head){
         Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of an element");
        int n = sc.nextInt();
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

        return head;

    }


    public static Node ListMerged(Node head1, Node head2){

        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node dummy = new Node(-1);
        Node tail = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
                tail.next = temp1;
                temp1 = temp1.next;
            }else{
                tail.next = temp2;
                temp2 = temp2.next;
            }
            tail = tail.next;
        }

        if(temp1 != null){
            tail.next = temp1;
        }else{
            tail.next = temp2;
        }

    }
    public static void main(String args[]){
       
        Node firstLinkedList = null;
        Node secondLinkedList = null;
        Node head = null;

        head = LinkedListCreation(firstLinkedList);
        Node tail = LinkedListCreation(secondLinkedList);

        Node merged = ListMerged(firstLinkedList, secondLinkedList);

        Node tempo = merged;

        while(tempo != null){
            System.out.print(tempo.data + " ");
            tempo = tempo.next;
        }
       
    }
}
