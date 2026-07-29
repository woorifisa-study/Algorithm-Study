import java.util.*;
class Solution {
    static List<String> list;
    static boolean[] visited;
  
    public String[] solution(String[][] tickets) {
        
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    void dfs(int count, String now, String path, String[][] tickets){
        if(count == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i] = true;
                dfs(count+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
            
        }
                
    }
    
}