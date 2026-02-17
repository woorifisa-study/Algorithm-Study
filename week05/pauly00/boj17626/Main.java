
import java.io.*;


public class Main {
    // static int count = 0;
    // static int setPow = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        for(int i=0; i<=n; i++) {
            dp[i] = i; // 모두 1일때 상황 (초기화)
        }

        // n까지의 최소 개수
        for(int i=1; i<=n; i++) {
            // 1^2 2^2 등 모든 케이스 확인을 위해
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i- j*j]+1);
            }
        }

        System.out.println(dp[n]);

        /*
        while(n > 0) {
            countPow(n);
            n = n- (setPow * setPow);
        }
        System.out.println(count);
        */


    }


    /* 최대 기준이라 틀린 함수
    public static void countPow(int n) {
        int i=1;
        setPow=1;
        while (true) { 
            if(n >= i*i) {
                i++;
            }
            else{
                setPow = i-1;
                count++;
                break;
            }
        }
    }
        */
}