import java.util.ArrayList;

public class LongestTreePath {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static ArrayList<Integer> getLongestPath(Node root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> leftNode = getLongestPath(root.left);
        ArrayList<Integer> rightNode = getLongestPath(root.right);
        if (rightNode.size() < leftNode.size()) {
            leftNode.add(root.data);
        } else {
            rightNode.add(root.data);
        }
        return leftNode.size() > rightNode.size() ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(100);
        Node node2 = new Node(20);
        Node node3 = new Node(10);
        Node node4 = new Node(50);
        Node node5 = new Node(5);
        Node node6 = new Node(130);
        Node node7 = new Node(110);
        Node node8 = new Node(140);

        node1.left = node2;
        node1.right = node6;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node6.left = node7;
        node6.right = node8;

        ArrayList<Integer> path = getLongestPath(node1);
        for(int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}
