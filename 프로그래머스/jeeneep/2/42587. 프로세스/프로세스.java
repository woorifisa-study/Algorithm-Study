import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int len = priorities.length;
        
        Queue<Process> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < len; i++) {
            q.offer(new Process(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        int answer = 0;
        
        while (!q.isEmpty()) {
            
            Process cur = q.poll();
            
            // 현재 프로세스 실행 O
            if (cur.priority == pq.peek()) {
                
                answer++;
                if (cur.index == location) return answer;
                pq.poll();
                                
            }
            // 현재 프로세스 실행 X
            else q.offer(cur);
        }

        return answer;
    }
    
    static class Process {
        int index;
        int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}