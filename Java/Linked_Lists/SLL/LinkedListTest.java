
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList sl = new LinkedList();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(5);

        sl.traverse();
        System.out.println("************");

        sl.sortedInsert(4);

        sl.traverse();
    }
}