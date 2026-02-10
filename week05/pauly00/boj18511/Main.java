
import java.io.*;
import java.util.Arrays;

public class Main {
    static int ans = 0; // 정답 저장
    static int n;
    static int[] elements; // 입력받은 k개의 원소들
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        tmp = br.readLine().split(" ");
        elements = new int[k];
        for(int i=0; i<k; i++) {
            elements[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(elements);
        dfs(0);
        System.out.print(ans);
    }

    public static void dfs(int current) {
        if(current > n) return;
        ans = Math.max(ans, current);
            
        for(int i=0; i<elements.length; i++) {
            int next = (current * 10) + elements[i];
            if(next <= n) dfs(next);
        }
    }
}