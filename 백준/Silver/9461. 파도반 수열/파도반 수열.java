import java.util.Scanner;

public class Main {
    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        memo = new long[101];

        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;

        for (int i=4; i<101; i++) {
            memo[i] = memo[i-3] + memo[i-2];
        }

        for (int tc=0; tc<t; tc++) {
            System.out.println(memo[sc.nextInt()]);
        }
    }
}