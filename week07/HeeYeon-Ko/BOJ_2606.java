import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 컴퓨터의 수(정점)
        int pair = Integer.parseInt(bf.readLine()); // 연결된 컴퓨터 쌍의 수
        int answer = 0;

        // 인접 리스트
        List<Integer>[] graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        // 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        StringTokenizer st;
        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(bf.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src].add(dst);
            graph[dst].add(src);
        }

        visited[1] = true;
        for (int num : graph[1]) {
            queue.add(num);
            visited[num] = true;
            answer++;
        }

        while(!queue.isEmpty()){
            int num = queue.poll();

            for (int n : graph[num]) {
                if(!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                    answer++;
                }

            }
        }

        System.out.println(answer);

    }
}
