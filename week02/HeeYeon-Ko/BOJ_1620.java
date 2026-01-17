import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); // 문제의 개수

        String[] PocketMon = new String[N+1]; // 포켓몬 이름
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();


        for (int i = 1; i < N+1; i++) {
            PocketMon[i] = bf.readLine();
            hashMap.put(PocketMon[i], i);
        }

        for (int i = 0; i < M; i++) {
            String str = bf.readLine();
            if(str.charAt(0) <= 57){ // 숫자
                int idx = Integer.parseInt(str);
                sb.append(PocketMon[idx]).append('\n');
            }
            else{ // 문자
                sb.append(hashMap.get(str)).append('\n');
            }
        }

        System.out.println(sb);
    }

}
