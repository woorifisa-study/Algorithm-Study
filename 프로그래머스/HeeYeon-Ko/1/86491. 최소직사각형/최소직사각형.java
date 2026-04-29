class Solution {
    public int solution(int[][] sizes) {
    
        int max_width = 0;
        int max_height = 0;
        
        // 두 변중 긴 부분을 가로로
        // 두 변중 짧은 부분을 세로로
        for(int i = 0; i < sizes.length; i++){
            int width = 0;
            int height = 0;
            
            if(sizes[i][0] > sizes[i][1]){
                width = sizes[i][0];
                height = sizes[i][1];
            }
            else{
                width = sizes[i][1];
                height = sizes[i][0];
            }
            
            if(max_width < width){
                max_width = width;
            }
            
            if(max_height < height){
                max_height = height;
            }
        }
        
        return max_width * max_height;
    }
    
 
}