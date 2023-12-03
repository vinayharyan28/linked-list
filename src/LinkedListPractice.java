
public class LinkedListPractice {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head, tail;
    public static int size = 0;

    void addFirst(int data){
        if (head == null){
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void addLast(int data){
        if (head == null){
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    void addMiddle(int data, int index){
        if (index == 0){
            addFirst(data);
            return;
        }
        Node temp = head;
        while (index <= index - 1){
            temp = temp.next;
            index--;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    void removeFirst(){
        if (head == null){
            return;
        }

        if (size == 1){
            head = null;
            tail = null;
            size--;
            return;
        }

        head = head.next;
        size--;
    }

    void removeLast(){
        if (head == null){
            return;
        }

        if (size == 1){
            head = null;
            tail = null;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
        size--;
    }

    int recursionSearch(int key, Node temp, int index){
        if (temp == null){
            return -1;
        }

        if (temp.data == key){
            return index;
        }
        return recursionSearch(key, temp.next, index+1);
    }

    int searchElement(int key){
        if (head == null){
            return -1;
        }

        Node temp = head;
        int index = 0;
        while (temp != null){
            index++;
            if (temp.data == key){
                return index;
            }
            temp = temp.next;
        }
        return -1;
    }

    void reverseLikedList(){
        Node prev=null, next, current = tail = head;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void deleteNthElement(int index){
        int size = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            size++;
        }

        System.out.println("size: " + size);

        if (index == size){
            removeFirst();
            return;
        }


        int findIndex = 1;
        int findToIndex = size - index;

        if (findToIndex == size-1){
            removeLast();
            return;
        }

        Node previous = head;
        while (findIndex < findToIndex){
            previous = previous.next;
            findToIndex++;
        }

        previous.next = previous.next.next;
    }

    void printLinkedList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    Node findMiddle(){
        Node temp = head;
        Node slow = temp, fast = temp;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    boolean checkPalindrome(){
        Node temp = head;
        if (temp == null || temp.next == null){
            return true;
        }

        // 1. Find mid
        Node middleNode = findMiddle();

        // 2. Reverse 2nd half
        Node prev = null;
        Node current = middleNode;
        while (current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node right = prev; // Right half head
        Node left = temp;

        // 3. Check left half and right half
        while (right != null){
            if (left.data != right.data){
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;

    }



    public static void main(String[] args) {
        LinkedListPractice ll = new LinkedListPractice();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(3);
//        ll.addLast(4);
//        ll.addLast(5);
//        ll.addMiddle(10, 2);
//        ll.removeFirst();
//        ll.printLinkedList();
//        ll.removeLast();
//        System.out.println();
//        ll.printLinkedList();
//
//        System.out.println();
//        System.out.println("Size of Linked list: " + size);
//
//        System.out.println(ll.searchElement(1));
//        System.out.println(ll.recursionSearch(100, head, 0));
//        ll.printLinkedList();
//        System.out.println();
//        ll.reverseLikedList();
//        ll.printLinkedList();
//        ll.deleteNthElement(3);
//        System.out.println();
//        ll.printLinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.printLinkedList();
        System.out.println(ll.checkPalindrome());

    }
}
