import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
    public static StringBuilder sb = new StringBuilder();
    public static int K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        func(1, 3, N);
        System.out.println(K);
        System.out.println(sb);

    }

    // 원판 n개를 a번 기둥에서 b번 기둥으로
    public static void func(int a, int b, int n){
        if(n==1){
            sb.append(a + " " + b).append("\n");
            K++;
            return;
        }

        // n-1개의 원판을 기둥 a에서 기둥 6-a-b로
        func(a, 6-a-b, n-1);
        sb.append(a + " " + b).append("\n");
        K++;
        func(6-a-b, b, n-1);
    }
}
