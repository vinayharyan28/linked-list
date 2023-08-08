public class SinglyLinkedListQuestions {
    Node head, tail;
    int size = 0;
    private static class Node{
        int value;
        Node next;

        public Node(){

        }

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void addLast(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void removeDuplicate(){
        Node temp = head;
        while (temp.next != null){
            if (temp.value == temp.next.value){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args){
        SinglyLinkedListQuestions questions = new SinglyLinkedListQuestions();
        questions.addLast(1);
        questions.addLast(1);
        questions.addLast(2);
        questions.addLast(3);
        questions.addLast(3);
        questions.addLast(3);
        questions.removeDuplicate();
        questions.display();
    }
}
