package Prac2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 휴가 일수 입력
        int[][] tasks = new int[n][2];

        for (int i = 0; i < n; i++) {
            tasks[i][0] = sc.nextInt(); // 기한 t 입력
            tasks[i][1] = sc.nextInt(); // 수익 p 입력
        }

        int[] dp = new int[n + 1];  // 최대 수익 저장 배열

        // 뒤에서부터 DP 배열 계산
        for (int i = n - 1; i >= 0; i--) {
            int time = tasks[i][0];
            int profit = tasks[i][1];

            // 현재 외주를 수행 가능한 경우
            if (i + time <= n) {
                dp[i] = Math.max(profit + dp[i + time], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];  // 현재 외주를 수행할 수 없는 경우
            }
        }

        System.out.println(dp[0]);  // 최대 수익 출력
        sc.close();
    }
}
