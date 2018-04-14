
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

    void deleteTreeHelper(Node a) {
        if (a == null) {
            return;
        }

        /* Delete subtrees */
        deleteTreeHelper(a.left);
        deleteTreeHelper(a.right);

        a = null;
    }

    void delete() {
        deleteTreeHelper(root);
        root = null;
    }

    void mirror() {
        root = mirror(root);
    }
 
    Node mirror(Node node) {
        if (node == null)
            return node;
 
        /* Mirror subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);
 
        /* Swap pointers */
        node.left = right;
        node.right = left;
 
        return node;
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

    /* Print out all binary tree root-to-leaf paths,
    one per line. Uses a recursive helper */
    void printPaths(Node a) {
        int path[] = new int[1000];
        printPathsRecur(a, path, 0);
    }
  
    /* Given a node, and an array containing
       the path from the root up to but not including this node,
       print all the root-leaf paths. */
    void printPathsRecur(Node a, int path[], int pathLen) {
        if (a == null) {
            return;
        }
  
        /* append this node to the path array */
        path[pathLen] = a.data;
        pathLen++;
  
        /* it's a leaf, so print the path that led to here */
        if (a.left == null && a.right == null)
            printArray(path, pathLen);
        else { 
            /* otherwise try both subtrees */
            printPathsRecur(a.left, path, pathLen);
            printPathsRecur(a.right, path, pathLen);
        }
    }
  
    /* Utility that prints out an array on a line */
    void printArray(int ints[], int len) {
        int i;
        for (i = 0; i < len; i++) 
            System.out.print(ints[i] + " ");
        System.out.println("");
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
