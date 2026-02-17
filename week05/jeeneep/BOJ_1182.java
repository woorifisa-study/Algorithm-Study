package week05.jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_1182 {

    static int N;
    static int S;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        check(0, 0);
        if (S == 0) count--;
        System.out.println(count);

    }

    public static void check (int index, int sum) {
        if (index == N) {
            if (sum == S) count++;
            return;
        }

        // 해당 인덱스 원소 포함
        check(index + 1, sum + arr[index]);


        // 해당 인덱스 원소 미포함
        check(index + 1, sum);
    } 
    
}
