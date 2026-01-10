import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // N명의 사람
        int K = Integer.parseInt(st.nextToken()); // K번째

        Queue<Integer> queue = new ArrayDeque<>();

        // 큐에 원소 삽입
        for (int i = 1; i <=N; i++) {
            queue.add(i);
        }

        sb.append('<');

        // 큐가 빌 때까지
        while(!queue.isEmpty()){
            int i;
            for (i = 1; i < K; i++) {
                int num = queue.remove();
                queue.add(num);
            }
            sb.append(queue.remove());
            if(!queue.isEmpty()){
                sb.append(", ");
            }
            else{
                break;
            }
        }
        //sb.deleteCharAt()
        sb.append('>');
        System.out.println(sb);

    }

}
