import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        int[] cur = {0, 0};
        
        Set<String> set = new HashSet<>();
        
        for(char c : dirs.toCharArray()){
            int nx = cur[0];
            int ny = cur[1];
            
            switch(c){
                case 'U':
                    ny++;
                    break;
                case 'D':
                    ny--;
                    break;
                case 'L':
                    nx--;
                    break;
                case 'R':
                    nx++;
                    break;
            }
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            set.add(cur[0] + "," + cur[1] + "," + nx + "," + ny);
            set.add(nx + "," + ny + "," + cur[0] + "," + cur[1]);
            
            cur[0] = nx;
            cur[1] = ny;
        }
        
        
        return set.size() / 2;
    }
}