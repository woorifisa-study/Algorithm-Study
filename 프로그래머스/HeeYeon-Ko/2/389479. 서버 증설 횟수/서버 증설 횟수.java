class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        
        for(int i = 0; i <= 23; i++){
            if(players[i] >= m && server[i] < (players[i]/m)){
                
                int add = (players[i] / m) - server[i];
                answer+= add;
                
                for(int j = i; j < i+k; j++){
                    if(j > 23){
                        break;
                    }
                    server[j] += add;
                }
            }
        }
        
        return answer;
    }
}