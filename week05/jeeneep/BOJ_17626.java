package week05.jeeneep;

import java.io.*;
import java.util.*;

// 17626
public class BOJ_17626 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int rootN = (int) Math.sqrt(N);

        // 1개로 가능?
        if (isSquare(N)) {
            System.out.println(1);
            return;
        }

        // 2개로 가능?
        for (int i = rootN; i >= 1; i--) {
            int result = N - (int) Math.pow(i, 2);

            if (isSquare(result)) {
                System.out.println(2);
                return;
            }
        }

        // 3개로 가능?
        for (int i = rootN; i >= 1; i--) {
            for (int j = N - i*i; j >= 1; j--) {
                if (isSquare(N - i*i - j*j)) {
                    System.out.println(3);
                    return;
                }
            }
        }

        // 1, 2, 3개로 불가능하다면 -> 4개로 가능
        System.out.println(4);
        return;

    }

    static boolean isSquare(int n) {
        if (n < 0) return false; 
        int root = (int) Math.sqrt(n);
        return root * root == n;
    }
    
}
