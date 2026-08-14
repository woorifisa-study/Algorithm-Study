class Solution {
    boolean solution(String s) {
        int count = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // ( 처리
            if(c == '(') {
                count++;
            }
            // ) 처리
            else {
                count--;
            }
            // 잘못된 순서
            if(count <0) return false;
        }
        // 최종 개수 (0이면 올바름)
        if(count == 0) return true;
        else return false;
    }
}