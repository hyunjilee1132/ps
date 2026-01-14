import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int y=0; y<n; y++) {
            for (int x=0; x<n; x++) {
                arr[y][x] = -1;
            }
        }

        int num = 1;
        for (int y=0; y<n; y++) {
            for (int x=0; x<num; x++) {
                arr[y][x] = sc.nextInt();
            }
            num++;
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0]; // base 

        for (int y=1; y<n; y++) {
            for (int x=0; x<n; x++) {
                // 양쪽 끝이면 바로 위의 원소만 가능,
                if (x==0) dp[y][x] = arr[y][x] + dp[y-1][x];
                else if (x==n-1) dp[y][x] = arr[y][x] + dp[y-1][x-1];
                // 나머지는 바로 위에있는 행에서 (본인기준 이전, 바로 윗 값)의 max값 더해주기     
                else dp[y][x] = arr[y][x] + Math.max(dp[y-1][x-1], dp[y-1][x]);
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (dp[n-1][i] > maxValue) maxValue = dp[n-1][i];
        }

        System.out.println(maxValue);
    }
}