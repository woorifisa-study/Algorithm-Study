import java.util.*;

class Solution {
    String[][] relation;
    int cols;
    List<List<Integer>> keys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        this.relation = relation;
        
        cols = relation[0].length;
            
        for(int size = 1; size <= cols; size++){
            dfs(0, new ArrayList<>(), size);
        }
        
        return keys.size();
    }
    
    void dfs(int start, List<Integer> cur, int size){
        
        if(cur.size() == size){
            if(!isMinimal(cur)) return;
            if(isUnique(cur)) keys.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = start; i < cols; i++){
            cur.add(i);
            dfs(i + 1, cur, size);
            cur.remove(cur.size() - 1);
        }
    }
    
    boolean isMinimal(List<Integer> cur){
        for(List<Integer> k : keys){
            if(cur.containsAll(k)) return false;
        }
        return true;
    }

    boolean isUnique(List<Integer> cur){
        Set<String> set = new HashSet<>();
        for(String[] row : relation){
            StringBuilder sb = new StringBuilder();
            for(int c : cur) sb.append(row[c]).append(",");
            set.add(sb.toString());
        }
        
        return set.size() == relation.length;
    }
}

// 하나로 되는지 확인
// 사용한 컬럼은 제외
// 두 개로 되는지 확인
