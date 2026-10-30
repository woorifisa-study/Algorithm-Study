import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 우선순위 큐(힙)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            queue.add(works[i]);
        }
        
        while(n > 0){
            int max = queue.poll();
            if(max == 0) return 0;
            
            max--;
            queue.add(max);
            n--;
        }
        
        while(!queue.isEmpty()){
            int val = queue.poll();
            answer += val * val;
        }
        
        return answer;
    }
}