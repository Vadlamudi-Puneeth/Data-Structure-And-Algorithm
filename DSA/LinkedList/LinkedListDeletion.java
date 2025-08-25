import java.util.*;

class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListDeletion {

    public static Node deletion(Node head, int pos){
     
        Node temp = head;
        Node temp2 = head;
        if(pos == 1){
            head = head.next;
        }else{
            int count = 1;
            while(count != pos){
                temp2 = temp;
                temp = temp.next;
                count++;
            }

            temp2.next = temp.next;
            

        }

        return head;
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

        
        head = deletion(head,sc.nextInt());
        Node tempNode = head;

        while(tempNode != null){
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }

    }
}
