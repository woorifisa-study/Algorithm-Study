import java.util.*;

class Solution {
    
    List<Integer> preorderList;
    List<Integer> postorderList;
    
    public int[][] solution(int[][] nodeinfo) {
        
        List<Node> nodes = new ArrayList<>();
        
        int N = nodeinfo.length;
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
            nodes.add(node);
        }
        nodes.sort((a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y);
        
        Node root = nodes.get(0);
        for (int i = 1; i < N; i++) {
            insertNode(root, nodes.get(i));
        }
        
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][N];
        answer[0] = preorderList.stream().mapToInt(i -> i).toArray();
        answer[1] = postorderList.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
    
    void preorder(Node root) {
        if (root == null) return;
        
        preorderList.add(root.id);
        preorder(root.left);
        preorder(root.right);
    }
    
    void postorder(Node root) {
        if (root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        postorderList.add(root.id);
    }
    
    void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }            
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    class Node {
        int id;
        int x, y;
        Node left, right;
        
        Node (int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.left = null;
            this.right = null;
        }
    }
}