/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17626                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17626                          #+#        #+#      #+#    */
/*   Solved: 2026/02/11 18:01:53 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static boolean isSquare(int x) {
        int r = (int) Math.sqrt(x);
        return r * r == x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1개 확인
        if (isSquare(n)) {
            System.out.println(1);
            return;
        }

        // 2개 확인
        for (int a = 1; a * a <= n; a++) {
            if (isSquare(n - a * a)) {
                System.out.println(2);
                return;
            }
        }

        // 3개 확인
        for (int a = 1; a * a <= n; a++) {
            for (int b = 1; b * b <= n - a * a; b++) {
                if (isSquare(n - a * a - b * b)) {
                    System.out.println(3);
                    return;
                }
            }
        }

        // 4개 
        System.out.println(4);
        return;
    }
}