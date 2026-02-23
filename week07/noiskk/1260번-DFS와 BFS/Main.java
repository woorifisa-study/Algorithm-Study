

/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1260                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1260                           #+#        #+#      #+#    */
/*   Solved: 2026/02/23 18:09:06 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점 번호 

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {    // 여기서 1~N번의 인덱스를 미리 만들어놓음
            graph.add(new ArrayList<>()); 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 번호가 작은 순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[N + 1];

        // DFS 수행 결과 출력
        dfs(graph, V, visited);

        sb.append("\n");


        visited = new boolean[N + 1]; // 다시 false 로 초기화

        // BFS 수행 결과 출력
        bfs(graph, V, visited);

        System.out.println(sb);

    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int cur, boolean[] visited){
        // 현재 노드 방문
        visited[cur] = true;
        sb.append(cur).append(" ");

        // 다음 노드 탐색
        for(int next : graph.get(cur)){
            if(!visited[next]){
                dfs(graph, next, visited);
            }
        }
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();

        // 시작점
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            // 현재 노드 방문
            int cur = queue.poll();
            sb.append(cur).append(" ");

            // 다음 노드
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }

        }
    }
}