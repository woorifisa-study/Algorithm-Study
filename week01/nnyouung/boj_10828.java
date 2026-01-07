import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int last = -1;

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                int x = Integer.parseInt(cmd.substring(5));
                stack.push(x);
                last = x;
            } else if (cmd.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }
        System.out.print(sb);
    }
}