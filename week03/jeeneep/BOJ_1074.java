package week03.jeeneep;

import java.io.*;
import java.util.*;

// 1074
public class BOJ_1074 {

    static int r;
    static int c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();

        int size = (int) Math.pow(2, N);
        find(0, 0, size);

        System.out.println(count);
    }

    public static void find(int row, int col, int size) {
        
        // Base Case
        if (size == 1) {
            return;
        }

        // N > 1 인 경우
        // 배열을 4등분하고, 재귀적으로 순서대로 방문하기
        int half = size / 2;

        // 1 사분면
        if (r < row + half && c < col + half) {
            find(row, col, half);
        }
        // 2 사분면
        else if (r < row + half && c >= col + half) {
            count += (half * half);
            find(row, col + half, half);
        } 
        // 3 사분면
        else if (r >= row + half && c < col + half) {
            count += (half * half * 2);
            find(row + half, col, half);
        }
        // 4 사분면
        else {
            count += (half * half * 3);
            find(row + half, col + half, half);
        }
    }
    
}
