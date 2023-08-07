public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertFirst(3);
        singlyLinkedList.insertFirst(2);
        singlyLinkedList.insertFirst(8);
        singlyLinkedList.insertFirst(17);
        singlyLinkedList.insertLast(5);
        singlyLinkedList.insert(100, 3);
        singlyLinkedList.display();
    }
}