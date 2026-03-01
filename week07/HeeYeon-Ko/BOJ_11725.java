import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static List<Integer>[] graph;  // 그래프
    static boolean[] visited;      // 방문 여부
    static int[] parent;           // 부모 노드 저장

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 인접리스트
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        parent = new int[N+1];

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src].add(dst);
            graph[dst].add(src);
        }

        visited[1] = true;
        dfs(1);

        for (int i = 2; i <= N ; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int node){
        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);

            if(!visited[nextNode]){
                visited[nextNode] = true;
                parent[nextNode] = node;
                dfs(nextNode);
            }
        }
    }
}
