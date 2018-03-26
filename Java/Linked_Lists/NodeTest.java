public class NodeTest {
    public static void main(String[] args){
        Node a = new Node();
        a.setValue(1);

        Node b = new Node();
        b.setValue(0);

        int compValue = a.compareTo(b);

        System.out.println(compValue);
    }
}