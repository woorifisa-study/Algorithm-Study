import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String type = cloth[1];
            // getOrDefault: 키 존재 시 값 반환, 아닐 시 기본값 반환
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int sum =1;
        for(int count : map.values()) {
            // 전체 경우의 수: (a+1)*(b+1) ... -1 (최소 1개는 걸쳐야 하므로)
            sum *= (count+1);
        }
        return sum-1;
    }
}