import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackUsingSwitchCase {

    static Node top = null;
    public static void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        if(top != null){
            System.out.println("This is the pushed Element in stack " + top.data);
            System.out.println();
        }
    }

    public static void pop(){
        if(top == null){
            System.out.println("Stack is empty");
        }else{
            System.out.println("The poped element in stack is: " + top.data);
            top = top.next;
        }
    }
    
    public static void peek(){
        if(top == null){
            System.out.println("There is no elements in stack");
        }else{
            System.out.println(top.data);
        }
    }
    
    public static void display(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;
        while(flag){
            
            System.out.println("Enter 1 for pushing the elements");
            System.out.println("Enter 2 for poping the elements");
            System.out.println("Enter 3 for printing the peek element");
            System.out.println("Enter 4 for displaying all the element");
            System.out.println("Enter 0 for Exit");
            
            
            int key = sc.nextInt();
            switch(key){
                case 1: push(sc.nextInt());
                        break;
                case 2: pop();
                        break;
                case 3: peek();
                        break;
                case 4: display();
                        break;
                case 0: System.out.println("Exiting....");
                        flag = false; 
                        break;
                default: System.out.println("Invalid choice");
            }


        }

    }    
}
