package week03.jeeneep;

import java.util.*;
import java.io.*;

// 22858
public class BOJ_22858 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 카드의 개수
        int N = Integer.parseInt(st.nextToken());
        // 카드를 섞은 횟수
        int K = Integer.parseInt(st.nextToken());

        // K번 카드를 섞은 후 카드의 배치 -> arrayS
        st = new StringTokenizer(br.readLine());
        int[] arrayS = new int[N];  
        for(int i = 0; i < N; i++) {
            arrayS[i] = Integer.parseInt(st.nextToken());
        }

        // D의 정보 -> arrayD
        st = new StringTokenizer(br.readLine());
        int[] arrayD = new int[N];  
        for(int i = 0; i < N; i++) {
            arrayD[i] = Integer.parseInt(st.nextToken());
        }

        // 카드를 섞기 전으로 되돌리는 작업을 K번 수행
        for (int i = 0; i < K; i++) {

            // 되돌리는 작업의 결과물을 저장하는 배열
            int[] result = new int[N];

            // i 번째 카드를 Di 번째 위치로 이동
            for (int j = 0; j < N ; j++) {
                result[arrayD[j] - 1] = arrayS[j];
            }

            // 되돌린 결과를 다시 arrayS에 저장
            System.arraycopy(result, 0, arrayS, 0, N);
        }

        // 결과 출력 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
                sb.append(arrayS[i]);
                sb.append(" ");
        }

        System.out.println(sb);
    }
    
}
