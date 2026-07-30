import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<String> result = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        
        // tickets 배열 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) { 
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
            
        
        visited = new boolean[tickets.length];       
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs(tickets, "ICN", path, 0);
            
        return result.toArray(new String[0]);
    }
    
    static boolean dfs(String[][] tickets, String now, List<String> path, int count) {
        
        // 티켓을 모두 사용하면 종료
        if (count == tickets.length) {
            result = new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets, tickets[i][1], path, count + 1)) return true;
                
                // 모든 티켓을 사용하지 못하는 경우
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}