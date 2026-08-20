import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.cost > dist[cur.to]) continue;
            
            for (Node next : graph[cur.to]) {
                int newCost = cur.cost + next.cost;
                
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
    
    static class Node {
        int to;
        int cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}