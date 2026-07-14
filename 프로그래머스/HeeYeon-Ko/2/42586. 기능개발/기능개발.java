import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int day = 0;
            if((100 - progresses[i]) % speeds[i] == 0){
                day = (100 - progresses[i])/speeds[i];
            }
            else{
                day = (100 - progresses[i])/speeds[i] + 1;
            }
            
            queue.add(day);
        }
        
        int num = queue.poll();
        int count = 1;
        while(!queue.isEmpty()){
            if(queue.peek() <= num){
                count++;
                queue.poll();
                continue;
            }
            
            answer.add(count);
                
            num = queue.poll();
            count = 1;
            
        }
        answer.add(count);
            
        return answer;
    }
}