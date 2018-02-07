
public class LinkedListTest {
    public static void main(String[] args){
        LinkedList<Integer> sl = new LinkedList<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(4);
        sl.add(89);  
        sl.add(91);

        sl.traverse();

        int l = sl.getLength();  
        System.out.println(l);
    }
}