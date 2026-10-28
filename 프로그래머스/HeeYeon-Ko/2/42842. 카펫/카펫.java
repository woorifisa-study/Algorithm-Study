class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown + 4) / 2;
        int multi = brown + yellow;
        
        for(int i = 1; i < multi/2 ; i++){
            if(multi%i == 0){
                if(i + multi/i == sum){
                    answer[0] = i;
                    answer[1] = multi/i;
                }
            }
        }
        
        return answer;
    }
}