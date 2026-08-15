class Solution {
    public int solution(int[][] sizes) {
        int maxX=0;
        int maxY=0;
        
        for(int[] size: sizes) {
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]); // 회전이 가능하므로
            
            if(maxX < x) maxX = x;
            if(maxY < y) maxY = y;
        }
        
        return maxX*maxY;
    }
}