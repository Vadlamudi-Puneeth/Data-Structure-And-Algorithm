import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

}

public class QueueImplementingInSwitchCase{

    static Node front = null;
    static Node rear = null;

    public static void Enqueue(int data){
        Node newNode = new Node(data);

        if(front == null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }

        if(rear != null){
            System.out.println(rear.data +  " ");    
        }
    }

    public static void Dequeue(){
        if(front == null){
            System.out.println("Queue is Empty");
        }else{
            front = front.next;
        }
    }

    public static void peek(){
        if(front == null){
            System.out.println("Queue is empty");
        }else{
            System.out.println(front.data);
        }
    }
    
    public static void display(){
        Node temp = front;
    
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("Enter 1 for adding elements in Queue");
            System.out.println("Enter 2 for removing elements in Queue");
            System.out.println("Enter 3 for peek element in Queue");
            System.out.println("Enter 4 for displaying elements in Queue");

            int key = sc.nextInt();
            
            switch(key){
                case 1: Enqueue(sc.nextInt());
                        break;
                case 2: Dequeue();
                        break;
                case 3: peek();
                        break;
                case 4: display();
                        break;
                case 0: System.out.println("Exiting...");
                        flag = false;
                        break;  
                default: System.out.println("Invalid Choice");
            }

        }

    }
}