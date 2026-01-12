package week02.jeeneep;

import java.io.*;
import java.util.*;


public class BOJ_2346 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Balloon> deque = new ArrayDeque<>();
 
        st = new StringTokenizer(br.readLine());
        
        // 덱 채우기
        for (int i = 0; i < N; i++) {
            Balloon newBalloon = new Balloon(i + 1, Integer.parseInt(st.nextToken()));
            deque.offer(newBalloon);
        }

        // 풍선 터뜨리기
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Balloon current = deque.pollFirst();            
            sb.append(current.index);

            if (deque.isEmpty()) break;
            else {
                sb.append(" ");
            }
            
            int count = current.value;
            if (count > 0) {
                count --;
                for (int i = 0; i < count; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
            else {
                for (int i = 0; i < Math.abs(count); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        // 출력
        System.out.println(sb);
    }
    
}

class Balloon {
    int index;
    int value;

    Balloon (int index, int value) {
        this.index = index;
        this.value = value;
    }
}
