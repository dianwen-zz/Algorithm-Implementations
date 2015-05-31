package main.resources;

/**
 * Created by dianwen on 5/25/15.
 */
public class BinarySearchTree {
    Node root;
    
    public static Node find(int value, Node root) {
        if(root.value == value) {
            return root;
        }
        if(value > root.value) {
            if(root.rightChild != null) {
                return find(value, root.rightChild);
            }
        }
        else {
            if(root.leftChild != null) {
                return find(value, root.leftChild);
            }
        }
        return null;
    }

    public static int findHeight(Node n) {
        if(n == null) {
            return 0;
        }
        int leftHeight = 1 + findHeight(n.leftChild);
        int rightHeight = 1 + findHeight(n.rightChild);
        return Math.max(leftHeight, rightHeight);
    }

    public static Node findMin(Node n) {
        if(n == null) {
            return null;
        }
        if(n.leftChild != null) {
            return findMin(n.leftChild);
        }
        return n;
    }

    public static Node findSuccessor(Node n) {
        if(n == null) {
            return null;
        }
        if(n.rightChild != null) {
            return findMin(n.rightChild);
        }
        Node cur = n;
        Node parent = cur.parent;
        while(parent != null && parent.rightChild == cur) {
            cur = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static Node findPredecessor(Node n) {
        if(n == null) {
            return null;
        }
        if(n.leftChild != null) {
            return findMax(n.leftChild);
        }
        Node cur = n;
        Node parent = cur.parent;
        while(parent != null && parent.leftChild == cur) {
            cur = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static Node findMax(Node n) {
        if(n == null) {
            return null;
        }
        if(n.rightChild != null) {
            return findMax(n.rightChild);
        }
        return n;
    }

    public void insert(int value) {
        if(root == null) {
            root = new Node(null, null, null, value);
            return;
        }
        Node parent = root;
        while(true) {
            if(value <= parent.value) {
                if(parent.leftChild == null) {
                    parent.leftChild = new Node(parent, null, null, value);
                    return;
                }
                else {
                    parent = parent.leftChild;
                    continue;
                }
            }
            else if(value > parent.value) {
                if(parent.rightChild == null) {
                    parent.rightChild = new Node(parent, null, null, value);
                    return;
                }
                else {
                    parent = parent.rightChild;
                    continue;
                }
            }
        }
    }

    public void delete(Node n) {
        if(n.leftChild == null && n.rightChild == null) {
            if(n.parent != null) {
                if (n.parent.leftChild == n) {
                    n.parent.leftChild = null;
                } else {
                    n.parent.rightChild = null;
                }
            }
            else {
                root = null;
            }
        }
        else if(n.leftChild == null && n.rightChild != null) {
            n.value = n.rightChild.value;
            n.rightChild = null;
        }
        else if(n.leftChild != null && n.rightChild == null) {
            n.value = n.leftChild.value;
            n.leftChild = null;
        }
        else {
            Node predecessor = findPredecessor(n);
            n.value = predecessor.value;
            if (predecessor.parent.leftChild == n) {
                predecessor.parent.leftChild = null;
            } else {
                predecessor.parent.rightChild = null;
            }
        }
    }

    public static void printPreOrder(Node n) {
        System.out.println(n.value);
        if(n.leftChild != null) {
            printPreOrder(n.leftChild);
        }
        if(n.rightChild != null) {
            printPreOrder(n.rightChild);
        }
    }


    public class Node {
        Node parent;
        Node leftChild;
        Node rightChild;
        int value;

        public Node(Node parent, Node leftChild, Node rightChild, int value) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.value = value;
        }

        public Node(Node n) {
            this.parent = n.parent;
            this.leftChild = n.leftChild;
            this.rightChild = n.rightChild;
            this.value = n.value;
        }

        public String toString() {
            return Integer.toString(value);
        }
    }
}
