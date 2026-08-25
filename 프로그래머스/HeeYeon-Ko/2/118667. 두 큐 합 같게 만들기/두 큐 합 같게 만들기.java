import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long total = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            total += queue1[i] + queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if(total%2 != 0){ // 합이 홀수일 경우
            return -1;
        }
        
        long target = total / 2;
        int limit = (q1.size() + q2.size()) * 2;
        
        while(true){
            if(answer > limit) return -1; // 한 바퀴 돈 경우
            if(sum1 == target) break;
            
            else if(sum1 > target){
                sum1 -= q1.peek();
                q2.add(q1.poll());
                answer++;
            }
            else{ // sum1 < target
                sum1 += q2.peek();
                q1.add(q2.poll());
                answer++;
            }
        }
        
        return answer;
    }
}