class Solution {
    public int solution(String name) {
        int count= 0;
        int move = name.length()-1; // 좌우이동
        
        // 글자수만큼 반복
        for(int i=0; i<name.length(); i++) {
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;
            count += Math.min(up, down); // if문 없이 바로 가능
            
            // A가 연속된 후 처음 A가 아닌 값 찾기
            int next = i+1;
            while(next < name.length() 
                 && name.charAt(next) == 'A') {
                next++;
            }
            
            // 오른쪽 i까지 이동 후 왼쪽으로 next에 접근, 왕복
            int rightMove = i*2 + name.length() - next;
            // 왼쪽 next 접근 후 오른쪽 i까지 이동, 왕복
            int leftMove = (name.length()-next)*2 +i;
            
            // 기존 방식(오른쪽으로 이동)과 비교
            move = Math.min(move, Math.min(rightMove, leftMove));
            
        }
        return count+move;
    }
}