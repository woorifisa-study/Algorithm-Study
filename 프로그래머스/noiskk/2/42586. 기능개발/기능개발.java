import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            int remainingDays = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offerLast(remainingDays);
        }
        
            
        while(!queue.isEmpty()){
            
            int current = queue.pollFirst();
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= current){
                queue.pollFirst();
                count++;
            }
            
            answerList.add(count);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}