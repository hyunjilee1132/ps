import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i=1; i<n+1; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1]; // 아니면 10001까지 만들어놓고 조건 안달고 다 채워넣기 
        
        if (n >= 1) dp[1] = arr[1];
        if (n >= 2) dp[2] = arr[1] + arr[2];
        // if (n >= 3) dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]); 이번잔을 꼭 마실 필요는 없음 - 이전잔까지의 dp도 비교해야됨

        for (int i=3; i<n+1; i++) {
            dp[i] = Math.max(dp[i-1], (Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i])));
        }

        System.out.println(dp[n]);
    }
}