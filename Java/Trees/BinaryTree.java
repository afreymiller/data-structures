
class BinaryTree {
    /* Root of Binary Tree */
    Node root;
 
    /* Constructors */
    BinaryTree(int data) {
        root = new Node(data);
    }
 
    BinaryTree() {
        root = null;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        /* Recur over left child */
        printInorder(node.left);

        /* Print data */
        System.out.print(node.data + " ");

        /* Recur over right child */
        printInorder(node.right);
    }

    /* Wrapper function to preserve the data */
    void traverseInorder() {
        printInorder(root);
    }
}
