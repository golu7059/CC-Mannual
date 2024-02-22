class Node {
    int value;
    Node left, right;

    Node(int item) {
        value = item;
        left = right = null;
    }
}

public class Ancesstor {
    Node root;

    Node findLCA(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.value == n1 || node.value == n2)
            return node;

        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        if (left_lca != null && right_lca != null)
            return node;

        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String args[]) {
        Ancesstor tree = new Ancesstor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(tree.root, 4, 5).value);
        System.out.println("LCA(4, 6): " + tree.findLCA(tree.root, 4, 6).value);
        System.out.println("LCA(3, 4): " + tree.findLCA(tree.root, 3, 4).value);
        System.out.println("LCA(2, 4): " + tree.findLCA(tree.root, 2, 4).value);
    }
}
