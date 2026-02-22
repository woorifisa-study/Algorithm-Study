package week06.jeeneep;

import java.io.*;
import java.util.*;

// 4796
public class BOJ_4796 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int L, P, V, result;
        int count = 0;
        while (true) {
            count++;
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;
    
            result = (V / P * L) + Math.min(V % P, L);

            sb.append("Case " + count + ": " + result + "\n");

        }
        System.out.println(sb);
    }
    
}
