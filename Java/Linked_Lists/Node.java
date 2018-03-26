class Node {
     
    private int value;
    private Node next;
     
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node ref) {
        this.next = ref;
    }

    public boolean compareTo(Node arg) {
        return (getValue() <= arg.getValue());
    }
}