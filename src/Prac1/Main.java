package Prac1;

import java.util.Scanner;

public class Main {
    static int[] numbers;  // 입력된 숫자들
    static int add, sub, mul;  // 연산자 개수
    static int minValue = Integer.MAX_VALUE;  // 최솟값
    static int maxValue = Integer.MIN_VALUE;  // 최댓값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();

        dfs(1, numbers[0], add, sub, mul);  // DFS 시작

        System.out.println(minValue + " " + maxValue);  // 최솟값과 최댓값 출력
        sc.close();
    }

    static void dfs(int idx, int currentResult, int add, int sub, int mul) {
        // 모든 숫자를 다 사용한 경우 결과 갱신
        if (idx == numbers.length) {
            minValue = Math.min(minValue, currentResult);
            maxValue = Math.max(maxValue, currentResult);
            return;
        }

        // 덧셈 수행
        if (add > 0) {
            dfs(idx + 1, currentResult + numbers[idx], add - 1, sub, mul);
        }
        // 뺄셈 수행
        if (sub > 0) {
            dfs(idx + 1, currentResult - numbers[idx], add, sub - 1, mul);
        }
        // 곱셈 수행
        if (mul > 0) {
            dfs(idx + 1, currentResult * numbers[idx], add, sub, mul - 1);
        }
    }
}
