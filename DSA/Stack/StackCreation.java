import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackCreation {

    static Node top = null;
    public static void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " ");
    }

    public static void peek(){
        if(top == null){
            System.out.println("Stack is empty");
        }else{
            System.out.println(top.data + " ");
        }
    }



    public static void display(){
        Node temp = top;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void pop(){
        if(top == null){
            System.out.println("No element is in top");
        }else{
            System.out.println(top.data);
            top = top.next;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        Node head = null;

        push(5);
        push(6);
        push(7);
        push(8);
        System.out.println("-----------------");
        peek();
        System.out.println("-----------------");
        pop();
        System.out.println("-----------------");
        display();
        

        
    }
}
