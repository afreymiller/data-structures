 class BinaryTreeTest {
    public static void main(String[] args) {
        
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
 
        tree1.root = new Node(1);
        tree2.root = new Node(1);
 
        tree1.root.left = new Node(2);
        tree2.root.left = new Node(2);

        tree1.root.right = new Node(3);
        tree2.root.right = new Node(3);
 
        tree1.root.left.left = new Node(4);
        tree2.root.left.left = new Node(5);

        boolean areEqual = tree1.treesAreIdentical(tree1.root, tree2.root);
        System.out.println(areEqual);
        
    }
}