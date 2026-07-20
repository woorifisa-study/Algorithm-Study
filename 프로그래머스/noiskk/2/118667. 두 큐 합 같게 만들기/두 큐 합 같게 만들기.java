import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        
        for(int i = 0; i < queue2.length; i++){
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        long total = sum1 + sum2;
        if(total % 2 == 1) return -1;
        
        long target = total / 2;
        
        int limit = queue1.length * 3; // 적당한 수
        
        while(answer < limit){
            
            if(sum1 == target) return answer;
            
            if(sum1 < target){
                int num = q2.pollFirst();
                sum1 += num;
                q1.offerLast(num);
            } else if(sum1 > target){
                int num = q1.pollFirst();
                sum1 -= num;
                q2.offerLast(num);
            }
            answer++;

        } 
        
        if(sum1 != target) return -1;
        
        return answer;
    }
}