import java.lang.Math;

public class LinkedList {
 
    private Node head;

    /* Output all nodes */
    public void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
     
    /* Add to end. Time: O(n) */
    public void add(int element) {
         
        Node tail = new Node();
        Node headRef = head;

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
    public void push(int element) {
        Node newHead = new Node();
        newHead.setValue(element);

        if (head == null) {
            newHead.setNext(null);
            head = newHead;
        } else {
            newHead.setNext(head);
            head = newHead;
        }
    }

    /* Remove head, return value. Time: O(1) */
    public int pop() {
        Node curr = head;
        int valAtHead = head.getValue();
        curr = curr.getNext();
        head = curr;
        return valAtHead;
    }

    /* Get specific element count. Time: O(n) */
    public int count(int element) {
        Node curr = head;
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
    public int getNth(int n) {
        int len = this.getLength();
        assert n < len : "Out of bounds";
        
        int i = 0;
        Node curr = head;
        while (i < n) {
            curr = curr.getNext();
            i++;
        }
        return curr.getValue();
    }

    /* Return length of linked list */
    public int getLength() {
        int length = 0;
        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.getNext();
        }
        return length;
    }

    /* If index is in-bounds, add there */
    public void insertNth(int index, int elem) {
        int len = getLength();
        if (index >= len) {
            return;
        }

        /* Initialize node to be added and keep 
        track of the previous and current nodes */
        Node inserted = new Node();
        inserted.setValue(elem);
        Node prev = new Node();
        Node curr = head;

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