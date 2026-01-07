import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        // StringBuilder: 출력할 문자열을 모아서 만들기 위한 객체
        // -> System.out.println을 매번 호출하면 느릴 수 있어 sb.append()로 누적 후 한 번에 출력
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int last = -1;

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.substring(5));
                queue.add(x);
                last = x;
            } else if (cmd.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');  // poll: 앞에서 꺼냄
            } else if (cmd.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');  // peek: 앞 값 보기
            } else if (cmd.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : last).append('\n');
            }
        }
        System.out.print(sb);
    }
}