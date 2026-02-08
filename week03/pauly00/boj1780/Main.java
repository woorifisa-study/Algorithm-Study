import java.io.*;

public class Main {
    // 결과값 변수 (전역으로 선언)
    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;        
    static int[][] numbers; // 행렬 입력값

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        numbers = new int[n][n]; // 할당
        
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                numbers[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        
        solve(0, 0, n);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    // 모두 같은지 체크
    public static void solve(int row, int col, int size) {
        if(isAllSame(row, col, size)) {
            int value = numbers[row][col]; // 첫번째 칸의 수
            if(value == -1) minusOne++;
            else if(value ==0) zero++;
            else if(value==1) plusOne++;
            return;
        }

        // 숫자가 다를 때 (분할정복)
        int newSize = size/3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                // 현재 위치에서 newSize만큼 i와 j를 곱해 이동 후 호출
                solve(row+i*newSize, col+j*newSize, newSize);
            }
        }
    }
    
    // 같은 숫자인지
    public static boolean isAllSame(int row, int col, int size) {
        int firstValue = numbers[row][col];
        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(numbers[i][j] != firstValue) return false;
            }
        }
        return true;
    }
}