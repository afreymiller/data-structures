import java.lang.Math;

public class LinkedList<T> {
 
    private Node<T> head;
     
    public void add(T element){
         
        Node<T> tail = new Node<T>();
        Node<T> headRef = head;

        /* Since we're appending to the tail, we 
        can just set it's values here */
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

    public void printMiddle(){
        Node<T> curr = head;
        int len = this.getLength();
        int middleIndex = (int)Math.floor((double)len/(double)2);



        System.out.println(middleIndex);
    }

    public int getLength() {
        int length = 0;
        Node<T> curr = head;
        while (curr != null) {
            length++;
            curr = curr.getNext();
        }
        return length;
    }

    public void traverse() {
        Node<T> curr = head;
        while (true) {
            if (curr == null) {
                break;
            } 
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
}