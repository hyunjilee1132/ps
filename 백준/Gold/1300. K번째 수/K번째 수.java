import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열 크기
        int k = sc.nextInt(); // 찾아야하는 순서(인덱스)

        // B[k]: 어떤 수를 찍었을 때, 1~어떤수 == k개, 어떤수 역산하기 
        long left = 1;
        long right = (long) N*N;  
        long result = 0;

        while (left <= right) {
            long mid = (left+right) / 2;

            long count = 0;
            for (int i=1; i<=N; i++) {
                // i행에서 mid보다 작거나 같은 값: mid/i개, N개를 넘어가지 않으므로 min값 비교
                count += Math.min(mid/i, N);
            }

            if (count >= k) {
                result = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}