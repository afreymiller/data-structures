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