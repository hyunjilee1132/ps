import java.util.Scanner;

public class Main {
    static int[] memo = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = f(N);
        System.out.println(result);
    }

    static int f(int n) {
        memo[1] = 1;
        memo[2] = 2;

        if (n > 2) {
            for (int i=3; i<=1000000; i++) {
                memo[i] = (memo[i-2] + memo[i-1]) % 15746; // 재귀 - stackoverflow - for문으로 수정  
            }
        }

        return memo[n];
    }
}

/**
 * 1: 1 - 1개
 * 2: 00, 11 - 2개
 * 3: 001, 100, 111 - 3개
 * 4: 0000, 0011, 1100, 1001, 1111 - 5개
 * 5: 00001, 10000, 00100, 
 *    00111, 11100, 10011, 11001, 11111 - 8개
 * 6: 000000
 *    000011, 100001, 110000, 001100, 100100, 001001,
 *    001111, 100111, 110011, 111001, 111100, 111111 - 13개
 * 
 * 1, 2, 3, 5, 8, 13
 * 
 * f(n) = f(n-2) + f(n-1);
 */