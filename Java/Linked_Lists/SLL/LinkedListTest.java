
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList sl = new LinkedList();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(5);
        sl.add(6);
        sl.add(9);

        sl.traverse();
        System.out.println("************");

        sl.deleteAtIndex(4);

        sl.traverse();
    }
}