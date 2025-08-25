import java.util.*;

class Node{
    
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }

}

public class LinkedListInsertion {

    public static Node insert(Node head, int pos,int data){
            
        Node newNode = new Node(data);
        
            if(pos == 1){
                newNode.next = head;
                head = newNode;
            }else{
                int count = 2;
                Node temp = head;

                while(count != pos){
                    temp = temp.next;
                    count++;
                }

                newNode.next = temp.next;
                temp.next = newNode;

            }

            return head;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Node head = null;
        Node top = null;
        
        for(int i = 0;i < n; i++){
            
            int data = sc.nextInt();
            Node newNode = new Node(data);

            if(head == null){
                head = top = newNode;
            }else{
                top.next = newNode;
                top = newNode;
            }

        }

        int pos = sc.nextInt();
        int data = sc.nextInt();

        head = insert(head,pos,data);

        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        
    }
}
