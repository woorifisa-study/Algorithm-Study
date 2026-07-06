class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown + 4) / 2;
        int multi = brown + yellow;
        
        int w = 0; // 가로
        int h = 0; // 세로
        
        for(int i = 1 ; i*i <= multi; i++){
            if(multi%i==0 && i*(sum-i)==multi){
                w = sum-i;
                h = i;
            }
        }
               
        answer[0] = w;
        answer[1] = h;
        return answer;
    }
}