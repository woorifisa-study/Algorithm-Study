import java.io.*;

public class Main {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Node head = new Node(1);
        Node tail = head;

        for (int i = 2; i <= N; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        tail.next = head;

        Node curr = head;
        Node prev = tail;

        int size = N;

        while (size > 0) {
            for (int i = 1; i < K; i++) {
                prev = curr;
                curr = curr.next;
            }
            sb.append(curr.value);
            if (size > 1) {
                sb.append(", ");
            }
            prev.next = curr.next;
            curr = curr.next;
            size--;
        }
        sb.append(">");
        System.out.println(sb);
    }
}