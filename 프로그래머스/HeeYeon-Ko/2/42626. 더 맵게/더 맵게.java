import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        // 우선순위 큐(최소힙)
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            queue.offer(scoville[i]);
        }
        
        while(queue.peek() < K){
            if(queue.size() < 2){
                return -1;
            }
            
            int first = queue.poll();
            int second = queue.poll();
            queue.offer(first + second * 2);
            count++;
        }
        
        return count;
    }
}