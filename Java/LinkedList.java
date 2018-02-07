import java.lang.Math;

public class LinkedList<T> {
 
    private Node<T> head;

    /* Access all nodes of linked list */
    public void traverse() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
     
    /* Add node to end of linked list */
    public void add(T element){
         
        Node<T> tail = new Node<T>();
        Node<T> headRef = head;

        /* Since we're adding the tail, set its value here */
        tail.setValue(element);
        tail.setNext(null);

        System.out.println("Adding: "+element);

        /* Check if the list is empty */
        if(head == null){
            /* Only one element, set head to tail */
            head = tail;
        } else {
            while (headRef != null) {
                if (headRef.getNext() == null) {
                    headRef.setNext(tail);
                    break;
                } else {
                    headRef = headRef.getNext();
                }
            }
        }
    }

    /* Add node at beginning of linked list */
    public void push(T element) {
        Node<T> newHead = new Node<T>();
        newHead.setValue(element);

        if (head == null) {
            newHead.setNext(null);
            head = newHead;
        } else {
            newHead.setNext(head);
            head = newHead;
        }
    }

    /* Get count of element in linked list */
    public int count(T element) {
        Node<T> curr = head;
        int count = 0;
        while (curr != null) {
            if (curr.getValue() == element) {
                count++;
            }
            curr = curr.getNext();
        }
        return count;
    }

    public T getNth(int n) {
        int len = this.getLength();
        assert n < len : "Out of bounds";
        
        int i = 0;
        Node<T> curr = head;
        while (i < n) {
            curr = curr.getNext();
            i++;
        }
        return curr.getValue();
    }

    /* Return length of linked list */
    public int getLength() {
        int length = 0;
        Node<T> curr = head;
        while (curr != null) {
            length++;
            curr = curr.getNext();
        }
        return length;
    }
}