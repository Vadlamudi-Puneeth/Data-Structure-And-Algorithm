import java.util.*;


class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListPalindrome{

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

    public static boolean isPalindrome(Node head){

        if(head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reverse = reversal(slow.next);

        Node temp1 = head;
        Node temp2 = reverse;

        while(temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;

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

        boolean flag = isPalindrome(head);
        System.out.println(flag);


    }
}