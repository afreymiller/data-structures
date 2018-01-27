/*****   Include the main() for testing and debugging  *****/
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList <String>();
        list.addFirst("p");
        list.addFirst("a");
        list.addFirst("e");
        list.addFirst("h");
        System.out.println(list);

            LinkedList<String> twin = list.copy3();
        System.out.println(twin);

        System.out.println(list.get(0));
    //		System.out.println(list.get(4));   //exception

        list.addLast("s");
        Iterator itr = list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();

        for(Object x : list)
            System.out.print(x + " ");
        System.out.println();

        list.insertAfter("e", "ee");
        System.out.println(list);
        System.out.println(list.getLast());

        list.insertBefore("h", "yy");
        System.out.println(list);

        list.remove("p");
        System.out.println(list);
        }
    }