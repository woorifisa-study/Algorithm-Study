// 토요일
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            // 0이면 배열의 최소값 출력 후 값 제거
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                Integer tmp = minHeap.poll();
                // 힙이 비어있을 때 0 할당
                tmp = (tmp==null) ? 0:tmp;
                System.out.println(tmp);
            }
            else {
                minHeap.add(input);
            }
        }
    }
}