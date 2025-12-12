import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc=0; tc<t; tc++) {
            int n = sc.nextInt();

            int ans = dp(n);

            System.out.println(ans);
        }
    }

    public static int dp(int n) {
        if (n<=2) return n;
        if (n==3) return 4;

        return dp(n-1) + dp(n-2) + dp(n-3);
    }
}