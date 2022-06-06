package 자료구조;

/**
 * date: 22.06.06
 */

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

public class StackImpl {
    Node head;
    void push(int data){
        if(head==null){
            head = new Node(data);
        }else{
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    int pop(){
        if(head == null){
            return -1;
        }
        int res = head.data;
        head = head.next;
        return res;
    }
    void print(){
        Node n = head;
        while(n.next != null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        StackImpl stackImpl = new StackImpl();
        stackImpl.push(1);
        stackImpl.push(2);
        stackImpl.push(3);
        stackImpl.push(4);
        stackImpl.push(5);
        stackImpl.print();
    }
}
