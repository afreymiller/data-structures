
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<Integer> sl = new LinkedList<Integer>();
        sl.add(3);
        sl.add(2);
        sl.add(54);
        sl.push(3);

        sl.traverse();
        int count = sl.count(3);
        System.out.println(count);
    }
}