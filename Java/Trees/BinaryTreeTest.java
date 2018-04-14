 class BinaryTreeTest {
    public static void main(String[] args) {
        
        BinaryTree tree1 = new BinaryTree();
 
        tree1.root = new Node(3);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(4);
        tree1.root.left.left = new Node(1);

        System.out.println(tree1.getLCA(tree1.root, 1, 4).data);
        
    }
}