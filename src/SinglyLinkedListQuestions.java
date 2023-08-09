
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

    public static SinglyLinkedListQuestions merge(SinglyLinkedListQuestions first, SinglyLinkedListQuestions second){
        Node f = first.head;
        Node s = second.head;

        SinglyLinkedListQuestions ans = new SinglyLinkedListQuestions();
        while (f != null && s != null){
            if (f.value < s.value){
                ans.addLast(f.value);
                f = f.next;
            }else{
                ans.addLast(s.value);
                s = s.next;
            }
        }

        while (f != null){
            ans.addLast(f.value);
            f = f.next;
        }

        while (s != null){
            ans.addLast(s.value);
            s = s.next;
        }

        return ans;
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

        SinglyLinkedListQuestions first = new SinglyLinkedListQuestions();
        SinglyLinkedListQuestions second = new SinglyLinkedListQuestions();
        first.addLast(1);
        first.addLast(4);
        first.addLast(7);
        first.addLast(9);

        second.addLast(0);
        second.addLast(2);
        second.addLast(3);
        second.addLast(8);
        System.out.println();
        SinglyLinkedListQuestions ans = merge(first, second);
        ans.display();
    }
}
