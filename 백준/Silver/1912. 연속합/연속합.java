import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] memo = new int[n];
        int result = dp(n, arr, memo);

        System.out.println(result);
    }

    static int dp(int n, int[] arr, int[] memo) {
        memo[0] = arr[0];
        int maxValue = memo[0]; // Integer.MIN_VALUE로 하면 비교할때 첫번째 원소 건너 뜀 - 첫 원소로 초기화

        for (int i=1; i<n; i++) { // 2이상일때부터 돌면서 비교
            memo[i] = Math.max(memo[i-1] + arr[i], arr[i]); // 연속 - 직전꺼랑 합한 값 비교 vs 지금꺼
            if (maxValue < memo[i]) maxValue = memo[i]; // Math.max로 비교 후 더 큰 값으로 갱신 
        }

        return maxValue;
    }
}