import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static int connectedLine=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) { // n+1개의 그래프 필요
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        isVisited = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            if(!isVisited[i]) {
                DFS(i);
                // DFS 돌때에만 요소의 개수 추가
                connectedLine++;
            }
        }
        System.out.println(connectedLine);
    }

    public static void DFS(int current) {
        isVisited[current] = true;
        
        for(int next: graph.get(current)) {
            if(!isVisited[next]) {
                DFS(next);
            }
        }

    }
}