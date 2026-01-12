package jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_1158 {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                queue.offer(i+1);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("<");
            
            while (!queue.isEmpty()) {
                for (int i = 0; i < K - 1; i ++) {
                    queue.offer(queue.poll());
                }
                sb.append(queue.poll()).append(", ");
            }

            sb.delete(sb.length() - 2, sb.length());
            sb.append(">");

            System.out.println(sb);

        }
}
