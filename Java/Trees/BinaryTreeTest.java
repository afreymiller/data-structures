 class BinaryTreeTest {

     /* TODO: Figure out whether these should be static or not */
    public static void sizeOfTest_1() {
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(5);
        tree1.root.left = new Node(3);
        tree1.root.left.right = new Node(4);
        tree1.root.right = new Node(10);
        tree1.root.right.left = new Node(7);
        tree1.root.right.right = new Node(11);

        assert tree1.sizeOf() == 6;
    }

    public static void sizeOfTest_2() {
        BinaryTree tree1 = new BinaryTree();

        assert tree1.sizeOf() == 0;
    }

    public static void sizeOfTest_3() {
        BinaryTree tree1 = new BinaryTree();

        tree1.root = new Node(6);

        assert tree1.sizeOf() == 1;
    }

    public static void main(String[] args) {
        
        // BinaryTree tree1 = new BinaryTree();
 
        // tree1.root = new Node(3);
        // tree1.root.left = new Node(2);
        // tree1.root.right = new Node(4);
        // tree1.root.left.left = new Node(1);

        // System.out.println(tree1.getLCA(tree1.root, 1, 4).data);

        sizeOfTest_1();
        sizeOfTest_2();
        sizeOfTest_3();
    }
}