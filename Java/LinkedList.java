public class LinkedList<T> {
 
    private Node<T> head;
    private Node<T> tail;
     
    public void add(T element){
         
        Node<T> nd = new Node<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /* Check if the list is empty */
        if(head == null){
            //since there is only one element, both head and 
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNext(nd);
            //set tail as newly created node
            tail = nd;
        }
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