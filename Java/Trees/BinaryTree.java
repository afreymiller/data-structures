
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

    /* Helper function for returning number
    of elements in a tree */
    int sizeOf(Node node) {
        if (node == null) {
            return 0;
        }

        return sizeOf(node.left) + 1 + sizeOf(node.right);
    }

    /* Return number of elements in tree */
    int sizeOf() {
        return sizeOf(root);
    }

    int getHeight(Node a) {
        /* Root is null */
        if (a == null) {
            return 0;
        } else {
            int lHeight = getHeight(a.left);
            int rHeight = getHeight(a.right);

            if (lHeight > rHeight) {
                return (lHeight + 1);
            } else {
                return (rHeight + 1);
            }
        }
    }

    boolean treesAreIdentical(Node a, Node b) {
        /* Both roots are empty */
        if (a == null && b == null) {
            return true;
        }

        /* Check if root data is equal, then
        recurse over both subtrees */
        if (a != null && b != null) {
            return (a.data == b.data && treesAreIdentical(a.left, b.left)
            && treesAreIdentical(a.right, b.right));
        }

        /* One tree has an empty node where another
        does not */
        return false;
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
