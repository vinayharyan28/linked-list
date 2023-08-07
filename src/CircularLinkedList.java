public class CircularLinkedList {
    private Node head;
    private Node tail;

    private static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int value){
        Node node = new Node(value);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display(){
        Node node = head;
        if (head != null){
            do {
                System.out.print(node.value + " -> ");
                node = node.next;
            }while (node != head);
        }
        System.out.println("null");
    }

    public void delete(int value){
         Node node = head;
         if (node == null){
             return;
         }
         if (node.value == value){
             head = head.next;
             tail.next = head;
             return;
         }

         do {
             Node n = node.next;
             if (n.value == value){
                 node.next=n.next;
             }
             node = node.next;
         }while (node != head);
    }
}
