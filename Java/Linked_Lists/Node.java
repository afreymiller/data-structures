class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
     
    private T value;
    private Node<T> next;
     
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> ref) {
        this.next = ref;
    }

    @Override
    public int compareTo(Node<T> arg) {
        return getValue().compareTo(arg.getValue());
    }
}