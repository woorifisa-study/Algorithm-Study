import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] state = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            state[i] = true; // 초기화
        }
        state[1] = false; // 1은 소수가 아님

        for (int i = 2; i <= N; i++) {
            if(!state[i]){ // 이미 지워진 수라면
                continue;
            }
            for (int j = i; j <= N; j+=i) {
                if(!state[j]){ // 이미 지워진 수라면
                    continue;
                }
                state[j] = false;
                count++;
                if(count==K){
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
