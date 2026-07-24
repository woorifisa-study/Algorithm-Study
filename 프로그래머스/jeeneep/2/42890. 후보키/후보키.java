import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        
        int n = relation.length;
        int m = relation[0].length;
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i < (1 << m); i++) { // 모든 컬럼 조합 검사
            
            HashSet<String> set = new HashSet<>();
            
            for (int j = 0; j < n; j++) { // 튜플마다
                StringBuilder sb = new StringBuilder();
                
                for (int k = 0; k < m; k++) {
                    if ((i & (1 << k)) != 0) { // 해당 속성이 조합에 포함될 경우
                        sb.append(relation[j][k]).append(",");
                    }
                }
                set.add(sb.toString());
            }
            
            // 유일성 만족
            if (set.size() != n) continue;
            
            // 최소성 만족
            boolean isMinimal = true;
            for (int j = 0; j < answer.size(); j++) {
                if ((i & answer.get(j)) == answer.get(j)) isMinimal = false;
            }
            if (isMinimal) answer.add(i);
                        
        }      
        return answer.size();
    }
}