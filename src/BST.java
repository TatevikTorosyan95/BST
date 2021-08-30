public class BST {
    private Node node;
    int h = 0;

    public void insert(int data) {
        node = insert(node, data);
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }

        if (data < node.value) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public void inOrder() {
        inOrder(node);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(node);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(node);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder() {
        levelOrder(node, height(node));
    }

    public void levelOrder(Node node, int l) {
        for (int i = 1; i <= l; i++) {
            printLevel(node,i);
            System.out.println();
        }
    }

    public void printLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.value + " ");
        } else if(level > 1) {
            printLevel(node.left, level-1);
            printLevel(node.right, level-1);
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else if(node.left != null){
            height(node.left);
            height(node.right);
            h++;
        } else if (node.right != null) {
            height(node.right);
            h++;
        }

        return h;

    }


    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(24);
        bst.insert(32);
        bst.insert(56);
        bst.insert(8);
        bst.insert(3);
        bst.insert(1);

//        bst.inOrder();
//        bst.preOrder();
//        bst.postOrder();
        bst.levelOrder();
    }
}
