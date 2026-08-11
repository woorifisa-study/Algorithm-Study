import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n > 0 && !pq.isEmpty()){
            int num = pq.poll();
            if(num > 0) pq.offer(num - 1);
            n--;
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}