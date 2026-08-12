import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int n : arr) {            
            if (deque.isEmpty() || deque.peekLast() != n) deque.offer(n);
        }
                   
        int size = deque.size();        
        int[] answer = new int[size];        
        for (int i = 0; i < size; i++) {
            answer[i] = deque.poll();
        }

        return answer;
    }
}