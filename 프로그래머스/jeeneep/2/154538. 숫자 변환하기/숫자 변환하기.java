import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        // 이미 x와 y가 같은 경우
        if (x == y) return 0;
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, 0)); // 시작점 큐에 넣기
        
        boolean[] visited = new boolean[y+1];
        visited[x] = true; // 시작점 방문 체크
        
        Node node;
        int nextNum;
        while (!queue.isEmpty()) {            
            node = queue.poll();
            
            if (node.num == y) return node.count;
            
            else if (node.num < y) {
                
                nextNum = node.num + n;
                if ((nextNum <= y) && !visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.add(new Node(nextNum, node.count + 1)); 
                }
                
                nextNum = node.num * 2;
                if ((nextNum <= y) && !visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.add(new Node(nextNum, node.count + 1)); 
                }
                
                nextNum = node.num * 3;
                if ((nextNum <= y) &&!visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.add(new Node(nextNum, node.count + 1)); 
                }
            }
        }
        
        return -1;
    }
    
    static class Node {
        int num;
        int count;
        
        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }        
    }
}