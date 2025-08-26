import java.util.*;


class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class RemoveNthNodeFromTheList {

    public static Node removeNthnode(Node head,int pos1,int len){
        int pos = len-pos1+1;
        Node temp = head;
        Node temp2 = null;

        if(pos == 1){
            head = head.next;
            return head;
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

    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of an element");
        int n = sc.nextInt();
        Node head = null;
        Node temp = null;

        int len = 1;
        for(int i = 0;i < n; i++){
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if(head == null){
                head = temp = newNode;
            }else{
                temp.next = newNode;
                temp = newNode;
                len+=1;
            }
        }


        head = removeNthnode(head,2,len);

        Node top = head;

        while(top != null){
            System.out.print(top.data + " ");
            top = top.next;
        }

    }
}
