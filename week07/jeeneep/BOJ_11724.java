package week07.jeeneep;

import java.io.*;
import java.util.*;

// 11724
public class BOJ_11724 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수 

        // 그래프 공간 만들기 
        graph = new ArrayList[N + 1]; 
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
        
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
    
    static void dfs(int cur) {

        visited[cur] = true;

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
