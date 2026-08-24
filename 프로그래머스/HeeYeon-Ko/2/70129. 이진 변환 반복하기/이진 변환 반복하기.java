class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String result = s;
        int zero = 0;
        int count = 0;
        
        while(!result.equals("1")){
            int beforeLength = result.length();
            result = result.replace("0", "");
            int afterLength = result.length();
            zero += beforeLength - afterLength;
            
            result = Integer.toString(afterLength, 2);
            count++;
        }
        
        answer[0] = count;
        answer[1] = zero;
        
        return answer;
    }
}