import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        int s1, s2;
        
        while(!pq.isEmpty() && pq.peek() < K){
            s1 = pq.poll();
            
            if(pq.isEmpty()){
                answer = -1;
                break;
            } else {
                s2 = pq.poll();
            }
            
            pq.offer(s1 + (s2 * 2));
            answer++;
        }
        
        return answer;
        
    }
}