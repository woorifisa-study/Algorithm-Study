import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 3. total 방 개수
        // 4. 현재 사용하고 있는 방 개수
        
        // 1. 시간 -> 분으로 파싱 (퇴실 시간에는 청소 10분을 미리 더함)
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < 2; j++) {
                String[] t = book_time[i][j].split(":");
                int minute = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
                if (j == 1) minute += 10;
                times[i][j] = minute;
            }
        }
        
        // 2. 입실 시간 기준 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        
        // 3. 퇴실 시간 기준으로 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int[] t : times){
            while(!pq.isEmpty() && pq.peek() <= t[0]) pq.poll();
            pq.offer(t[1]);
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}