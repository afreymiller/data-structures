import java.lang.Math;

public class LinkedList<T> {
 
    private Node<T> head;

    /* Log all nodes */
    public void traverse() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
     
    /* Add to end. Time: O(n) */
    public void add(T element) {
         
        Node<T> tail = new Node<T>();
        Node<T> headRef = head;

        /* Set tail value here */
        tail.setValue(element);
        tail.setNext(null);

        System.out.println("Adding: "+element);

        /* Check if list is empty */
        if (head == null) {
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

    /* Add node before head. Time: O(1) */
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

    /* Remove head and return its value.
    Time: O(1) */
    public T pop() {
        Node<T> curr = head;
        T valAtHead = head.getValue();
        curr = curr.getNext();
        head = curr;
        return valAtHead;
    }

    /* Get specific element count. Time: O(n) */
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

    /* Time: O(n) */
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

    /* If index is in-bounds, add there */
    public void insertNth(int index, T elem) {
        int len = getLength();
        if (index >= len) {
            return;
        }

        Node<T> inserted = new Node<T>();
        inserted.setValue(elem);
        Node<T> prev = new Node<T>();
        Node<T> curr = head;

        int i = 0;
        while (i < index) {
            /* Keep track of previous node */
            prev = curr;
            curr = curr.getNext();
            i++;
        }

        prev.setNext(inserted);
        inserted.setNext(curr);
    }
}