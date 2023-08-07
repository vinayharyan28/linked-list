public class DoublyLinkedList {
    Node head;
    private static class Node{
        int value;
        Node next, previous;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next, Node previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.previous = null;
        if (head != null){
            head.previous = node;
        }
        head = node;
    }

    public void display(){
        Node temp = head;
        Node last = null;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Reversed doubly linked list: ");
        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.println("null");
    }

    public void insertLast(int value){
        Node node = new Node(value);
        Node last = head;
        if (head == null){
            node.previous = null;
            head = node;
            return;
        }
        while (last.next != null){
            last = last.next;
        }
        last.next = node;
        node.previous = last;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int value){
        Node previous = find(after);
        if (previous == null){
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(value);
        node.next = previous.next;
        previous.next = node;
        node.previous = previous;
        if (node.next != null){
            node.next.previous = node;
        }
    }
}
