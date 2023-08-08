public class Main {
    public static void main(String[] args) {
        System.out.println("Singly linked list: ");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertFirst(3);
        singlyLinkedList.insertFirst(2);
        singlyLinkedList.insertFirst(8);
        singlyLinkedList.insertFirst(17);
        singlyLinkedList.insertLast(5);
        singlyLinkedList.insert(100, 3);
        System.out.println(singlyLinkedList.deleteFirst());
        System.out.println(singlyLinkedList.deleteLastElement());
        System.out.println(singlyLinkedList.delete(2));
        singlyLinkedList.insertRecursion(88, 2);
        singlyLinkedList.display();

        System.out.println("Doubly linked list: ");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.insertFirst(3);
        doublyLinkedList.insertFirst(4);
        doublyLinkedList.insertFirst(5);
        doublyLinkedList.insertLast(6);
        doublyLinkedList.insert(3, 33);
        doublyLinkedList.display();

        System.out.println("Circular linked list: ");
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert(10);
        circularLinkedList.insert(11);
        circularLinkedList.insert(12);
        circularLinkedList.insert(13);
        circularLinkedList.insert(14);
        circularLinkedList.delete(12);
        circularLinkedList.display();
    }
}