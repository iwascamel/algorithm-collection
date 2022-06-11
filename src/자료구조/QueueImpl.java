package 자료구조;

public class QueueImpl {
    Node head;
    Node tail;

    void offer(int data){
        Node node = new Node(data);
        
        if(head==null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    int poll(){
        if(head==null){
            return -1;
        }

        int res = head.data;
        head = head.next;
        return res;
    }
    void print(){
        Node n = head;

        while(n.next!=null){
            System.out.println(n.data);
            n=n.next;
        }
        System.out.println(n.data);
    }
    public static void main(String[] args) {
        QueueImpl queueImpl = new QueueImpl();
        queueImpl.offer(1);
        queueImpl.offer(2);
        queueImpl.offer(3);
        queueImpl.offer(4);
        queueImpl.offer(5);

        int poll = queueImpl.poll();
        System.out.println("poll = " + poll);

        queueImpl.print();
    }
}
