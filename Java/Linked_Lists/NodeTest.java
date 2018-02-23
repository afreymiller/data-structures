public class NodeTest {
    public static void main(String[] args){
        Node<Integer> a = new Node<Integer>();
        a.setValue(1);

        Node<Integer> b = new Node<Integer>();
        b.setValue(0);

        int compValue = a.compareTo(b);

        System.out.println(compValue);
    }
}