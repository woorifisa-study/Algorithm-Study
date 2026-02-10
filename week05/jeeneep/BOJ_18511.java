package week05.jeeneep;

import java.io.*;
import java.util.*;

// 18511
public class BOJ_18511 {

    static int N;
    static int K;
    static Integer[] elements;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        elements = new Integer[K];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < K; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        
        // elements 배열에 대해 내림차순 정렬
        Arrays.sort(elements, Collections.reverseOrder());

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int current) {
        // Base Case
        if (current > N) {
            return;
        }

        // 최댓값 갱신
        if (current > max) {
            max = current;
        }

        // K개의 원소를 하나씩 붙여보기 
        for (int i = 0; i < K; i++) {
            dfs(current * 10 + elements[i]);
        }
    }
}

