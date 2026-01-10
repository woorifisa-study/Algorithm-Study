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
            if (cmd.startsWith("push_front")) {
                int x = Integer.gitparseInt(cmd.substring(11));
                stack.offerFirst(x);
                last = x;
            } else if (cmd.startsWith("push_back")) {
                int x = Integer.parseInt(cmd.substring(10));
                stack.offerLast(x);
                last = x;
            } else if (cmd.equals("pop_front")) {
                sb.append(stack.isEmpty() ? -1 : stack.pollFirst()).append('\n');
            } else if (cmd.equals("pop_back")) {
                sb.append(stack.isEmpty() ? -1 : stack.pollLast()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (cmd.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (cmd.equals("front")) {
                sb.append(stack.isEmpty() ? -1 : stack.peekFirst()).append('\n');
            } else if (cmd.equals("back")) {
                sb.append(stack.isEmpty() ? -1 : stack.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}