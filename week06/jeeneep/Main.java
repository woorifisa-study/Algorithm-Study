package week06.jeeneep;

import java.io.*;
import java.util.*;

// 10250
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()); 
            int H = Integer.parseInt(st.nextToken()); // 호텔의 층수 
            int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
            int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님인지

            int floor = N % H;
            int room_number = N / H + 1;
            if (floor == 0) {
                floor = H;
                room_number = N / H;
            }

            System.out.println(floor * 100 + room_number);  
        }
    }  
}
