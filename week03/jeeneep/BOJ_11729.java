package week03.jeeneep;

import java.io.*;
import java.util.*;

// 11729
public class BOJ_11729 {

    static StringBuilder sb;
    static int count = 0;

    public static void main(String[] args) throws IOException {
       
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        sb = new StringBuilder();

        hanoi(n, 1, 2, 3);


        // Math.pow(2, n) - 1 공식으로도 계산 가능 
        System.out.println(count);

        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            count++;
            
            return;
        }
        else {

            // 치우기
            hanoi(n-1, start, to, mid);

            // 옮기기
            sb.append(start).append(" ").append(to).append("\n");
            count++;

            // 다시 가져오기
            hanoi(n-1, mid, start, to);
        }
    }
    
}
