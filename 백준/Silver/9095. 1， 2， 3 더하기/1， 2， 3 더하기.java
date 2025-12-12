import java.util.Scanner;

public class Main {
    static int[] cache;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cache = new int[12];
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;

        int t = sc.nextInt();
        for (int tc=0; tc<t; tc++) {
            int n = sc.nextInt();

            int ans = dp(n);

            System.out.println(ans);
        }
    }

    public static int dp(int n) {
        if (cache[n] > 0) return cache[n];
        else {
            return cache[n] = dp(n-1) + dp(n-2) + dp(n-3);
        }
    }
}