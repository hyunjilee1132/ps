import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 자릿수 

        int[][] dp = new int[n+1][10]; // [n자릿수(0제외)][끝수범위(0~9)]
        
        // base: dp[1~9] = 1개씩 존재, 범위는 1부터 시작
        for (int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        // dp[n][1] = dp[n-1][0] + dp[n-1][2]; 자릿수n-1의 수에서 끝이 0인 것들의 개수 + 끝이 2인 것들의 개수
        for (int nn=2; nn<=n; nn++) {
            // 0, 9는 예외처리 - 각각 1, 8에만 붙을 수 있음 
            dp[nn][0] = dp[nn-1][1] % 1000000000;
            dp[nn][9] = dp[nn-1][8] % 1000000000;
            for (int j=1; j<9; j++) {
                dp[nn][j] = (dp[nn-1][j-1] + dp[nn-1][j+1]) % 1000000000; // 개수 
            }
        }

        long result = 0;
        for (int i=0; i<=9; i++) {
            result += dp[n][i];
            result %= 1000000000;
        }

        System.out.println(result);
    }
}