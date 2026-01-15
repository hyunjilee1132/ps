import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단 개수

        int[] arr = new int[n+1];
        for (int i=1; i<n+1; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] dp = new int[301]; // n은 최대 300

        if (n>=1) dp[1] = arr[1];
        if (n>=2) dp[2] = arr[1] + arr[2]; // 주어지는 수는 모두 양수, 굳이 max값 안구해도 두 계단 모두 더하면 max가 됨
        if (n>=3) dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]); // 두 계단 점프 or 한 계단씩 연속
        
        for (int i=4; i<n+1; i++) {
            dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3]+arr[i-1]); // 세 계단 연속 XX (두 계단 전에서 점프 해와서 + 현재 or 세 계단 전 최대 + 직전 계단 + 현재)
        }

        System.out.println(dp[n]);
    }
}