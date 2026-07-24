import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        // 원하는 제품 목록 map 만들기
        for(int i = 0; i < want.length; i++){
            for(int j = 0; j < number[i]; j++){
                wantMap.put(want[i], wantMap.getOrDefault(want[i] , 0) + 1);   
            }
        }
            
        int answer = 0;
        
        // 할인 품목 map 만들기
        HashMap<String, Integer> windowMap = new HashMap<>();
        for(int i = 0; i < 10; i++){
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }
        if(windowMap.equals(wantMap)) answer++;
        
        // 하루씩 옮겨가면서 원하는 품목 = 할인 품목 인지 확인
        for(int start = 0; start + 10 < discount.length; start++){
            
            int count = windowMap.get(discount[start]) - 1;
            if(count == 0){
                windowMap.remove(discount[start]);
            } else{
                windowMap.put(discount[start], count);    
            }
            
            windowMap.put(discount[start + 10], windowMap.getOrDefault(discount[start + 10], 0) + 1);
            
            if(windowMap.equals(wantMap)) answer++;
        }
        
        return answer;
    }
}