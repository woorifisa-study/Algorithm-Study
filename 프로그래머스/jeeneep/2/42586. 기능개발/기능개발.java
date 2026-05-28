import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 작업이 끝나기까지 남은 일수를 저장
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            
            int current_progress = progresses[i];
            int count_days = 0;
            
            while (current_progress < 100) {
                count_days ++;
                current_progress += speeds[i];
            }
            
            q.add(count_days);
        }
        
        
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            
            int count = 1;
            
            int current = q.poll();
            
            while (!q.isEmpty() && q.peek() <= current) {
                count++;
                q.poll();
            }
            
            list.add(count);        
        }
        
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}