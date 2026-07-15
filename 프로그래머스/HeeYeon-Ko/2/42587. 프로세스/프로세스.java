import java.util.*;
class Solution {
    
    static Queue<Integer> queue;
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> order = new ArrayList<>();
        queue = new LinkedList<>();
        
        for(int i = 0; i<priorities.length; i++){
            queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            if(priorities[cur] >= findMax(priorities)){
                order.add(cur);
            }
            
            else{
                queue.offer(cur);
            }
        }
        
        for(int i = 0; i<order.size(); i++){
            System.out.println(order.get(i));
            if(order.get(i) == location){
                answer = i + 1;
            }
        }
        
        return answer;
    }
    
    public int findMax(int[] priorities){
        int max = Integer.MIN_VALUE;
        
        for(int num : queue){
            if(max < priorities[num]){
                max = priorities[num];
            }
        }
        
        return max;
    }
}