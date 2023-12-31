
public class SinglyLinkedList {
    private Node head, tail;
    private int size;

    public SinglyLinkedList(){
        this.size = 0;
    }

    private static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int value){
        if (tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insert(int value, int index){
        if (index == 0){
            insertFirst(value);
            return;
        }

        if (index == size){
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i=1; i<index; i++){
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteLastElement(){
        if (size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        return value;
    }

    public int delete(int index){
        if (index==0){
            deleteFirst();
        }

        if (index == size-1){
            return deleteLastElement();
        }

        Node previous = get(index-1);
        int value = previous.next.value;
        previous.next = previous.next.next;
        return value;
    }

    public void insertRecursion(int value, int index){
        head = insertRecursion(value, index, head);
    }

    private Node insertRecursion(int value, int index, Node node){
        if (index == 0){
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertRecursion(value, index-1, node.next);
        return node;
    }
}
