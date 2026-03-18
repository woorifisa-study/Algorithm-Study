import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static int[] parent; // 부모 노드 저장

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<n-1; i++) {
            // StringTokenizer란? : 문자열을 특정 구분자로 나누어 토큰으로 분리하는 클래스
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b); // 서로 연결
            graph.get(b).add(a);
        }

        isVisited = new boolean[n+1];
        bfs(1);
        
        for(int i=2; i<=n; i++) {
            System.out.println(parent[i]); // 부모 노드 출력
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;

        while(!q.isEmpty()) {
            int current = q.remove();

            for(int next: graph.get(current)) {
                if(!isVisited[next]) {
                    q.add(next);
                    isVisited[next] = true;
                    parent[next] = current;
                }
            }
        }
    }
}