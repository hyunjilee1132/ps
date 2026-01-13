import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] cost = new int[n][3]; // 3: R G B
        for (int i=0; i<n; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        int[][] memo = new int[n][3];

        // base 
        memo[0][0] = cost[0][0];
        memo[0][1] = cost[0][1];
        memo[0][2] = cost[0][2];

        // 현재 위치(R, G, B)까지 오면서 직전과 안겹치면서 + 최솟값들 더한거 누적하기 
        for (int i=1; i<n; i++) {
            memo[i][0] = cost[i][0] + Math.min(memo[i-1][1], memo[i-1][2]);
            memo[i][1] = cost[i][1] + Math.min(memo[i-1][0], memo[i-1][2]);
            memo[i][2] = cost[i][2] + Math.min(memo[i-1][0], memo[i-1][1]);
        }

        Arrays.sort(memo[n-1]);

        System.out.println(memo[n-1][0]);
    }
}