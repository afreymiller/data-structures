
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

        System.out.print(node.data + " ");

        /* Recur over right child */
        printInorder(node.right);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        /* Recur over left child */
        printPostorder(node.left);

        /* Recur over right child */
        printPostorder(node.right);

        System.out.print(node.data + " ");
    }

    void printPreorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        /* Recur over left child */
        printPreorder(node.left);

        /* Recur over right child */
        printPreorder(node.right);
    }

    /* Wrapper functions to preserve the data */
    void traverseInorder() {
        printInorder(root);
    }

    void traversePostorder() {
        printPostorder(root);
    }

    void traversePreorder() {
        printPreorder(root);
    }
}
