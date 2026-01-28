import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 재료의 개수
        int m = sc.nextInt(); // 도달해야하는 수

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int L = 0;
        int R = n-1;

        int count = 0;

        while (L < R) {
            if (arr[L] + arr[R] == m) {
                count++;
                L++;
                R--;
            }
            else if (arr[L] + arr[R] < m) L++;
            else R--;
        }

        System.out.println(count);
    }
}