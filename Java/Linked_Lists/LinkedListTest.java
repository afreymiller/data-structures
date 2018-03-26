
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList sl = new LinkedList();
        sl.add(3);
        sl.add(2);
        sl.add(54);
        sl.push(8);
        sl.push(1);
        sl.add(6);
        sl.add(7);

        sl.traverse();
        System.out.println("************");

        sl.insertNth(4, 99);

        sl.traverse();
    }
}