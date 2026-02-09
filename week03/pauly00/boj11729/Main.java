import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 원판 개수
        int k=0; // 옮긴 횟수
        k +=Math.pow(2, n)-1; // 2^n-1개
        System.out.println(k);
        
        solve(n, 1, 2, 3);
        bw.flush();
        bw.close(); // 메모리 누수 방지
    }
    
    
    public static void solve(int n, int start, int mid, int end) throws IOException {
        if(n==1) {
            bw.write(start + " " + end + "\n");
            return;
        }
        solve(n-1, start, end, mid); // 목적지를 보조로 옮김
        bw.write(start + " " + end + "\n"); // 가장 큰 원판을 목적지로

        solve(n-1, mid, start, end); // 시작점을 보조로 옮김
    }

    // bw.flush();
}