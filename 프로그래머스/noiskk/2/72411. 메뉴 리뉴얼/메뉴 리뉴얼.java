import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i = 0; i < orders.length; i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = new String(c);
        }
        
        for(int num : course){
            
            map = new HashMap<>();
            
            for(String order : orders){                
                if(order.length() < num) continue;
                func(order, 0, new StringBuilder(), num);
            }
            
            int max = 0;
            for(int value : map.values()){
                max = Math.max(value, max);
            }
            if(max < 2) continue;
            
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == max) answer.add(entry.getKey());
            }
        
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    void func(String order, int start, StringBuilder sb, int num){
        
        if(sb.length() == num){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i = start; i < order.length(); i++){
            sb.append(order.charAt(i));
            func(order, i + 1, sb, num);
            sb.deleteCharAt(sb.length() - 1);    
        }
        
    }
}