import java.io.*;

public class Main {
    static long sumGCD; // GCD 합

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        
        for(int i=0; i<t; i++) {
            sumGCD=0;
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int[] gcdArray = new int[n];

            for(int j=0; j<n; j++) {
                gcdArray[j] = Integer.parseInt(tmp[j+1]); 
            }

            // 2개 고름
            for(int j=0; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    sumGCD += GCD(gcdArray[j], gcdArray[k]);
                }
            }

            System.out.println(sumGCD);
        }        
    }

    public static int GCD(int a, int b) {
        // 유클리드 호제법
        while (b!=0) {
            int tmp = a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
}