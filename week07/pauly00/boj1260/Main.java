import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]); // 정점
        int m = Integer.parseInt(tmp[1]); // 간선
        int v = Integer.parseInt(tmp[2]); // 정점번호

        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            tmp=br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            graph.get(a).add(b);
            graph.get(b).add(a); // 무방향그래프 기준
            
        }
        // 작은번호 먼저 방문
        for(int i=1; i<=n; i++) {
            Collections.sort(graph.get(i));
        }

        isVisited = new boolean[n+1];
        DFS(v);
        System.out.println();

        Arrays.fill(isVisited, false); // 배열 초기화
        BFS(v);
    }

    public static void BFS(int start) {
        // 큐는 인터페이스이므로
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start); // 시작점 넣기
        isVisited[start] = true; // 방문

        while(!q.isEmpty()) {
            int current = q.remove(); // 가장 먼저 들어온 노드 꺼내기
            System.out.print(current + " "); // 큐에서 꺼냈을때 출력

            for(int next: graph.get(current)) {
                if(!isVisited[next]) {
                    q.add(next); // 다음 방문 예약
                    isVisited[next]=true;
                }
            }
        }
    }

    public static void DFS(int current) {
        isVisited[current] = true; // 현재 노드 방문
        System.out.print(current + " "); //방문하자마자 출력
        
        for(int next: graph.get(current)) {
            if(!isVisited[next]) {
                DFS(next); // 다음 노드로 빠진다.
            }
        }
    }
}