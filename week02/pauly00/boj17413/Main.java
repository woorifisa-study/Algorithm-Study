import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder tag = new StringBuilder();
        boolean isTag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                isTag = true;
                tag.append(c);
            }
            else if (c == '>') {
                tag.append(c);
                System.out.print(tag);
                tag.setLength(0);
                isTag = false;
            }
            else if (isTag) {
                tag.append(c);
            }
            else if (c == ' ') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
            else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
