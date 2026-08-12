import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 최소
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // 최대
        
        for(String operation : operations){
            String[] s = operation.split(" ");
            
            if(s[0].equals("I")){ // 큐에 숫자 삽입
                int num = Integer.parseInt(s[1]);
                pq1.offer(num);
                pq2.offer(num);
            } else {
                if(s[1].equals("-1") && !pq1.isEmpty()){ // 큐에서 최솟값 삭제
                    int min = pq1.poll();
                    pq2.remove(min);
                } else if (!pq2.isEmpty()){ // 큐에서 최댓값 삭제
                    int max = pq2.poll();
                    pq1.remove(max);
                }
            }
        }
        
        if(!pq1.isEmpty()){
            answer[0] = pq2.peek();
            answer[1] = pq1.peek(); 
        }
       
        return answer;
    }
}