import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        // 소수여부 체크(true: 소수x, false: 소수o)
        boolean[] isNotPrime = new boolean[N+1];
        // 0, 1은 소수가 아니므로 true 처리
        isNotPrime[0] = isNotPrime[1] = true; 

        // 에라토스테네스의 체
        for (int i=2; i*i<=N; i++) {
            // 지워졌으면 건너뛰기
            if (isNotPrime[i]) continue;

            // i가 소수면, i 배수를 i*i부터 시작해서 N까지 지우기
            for (int j=i*i; j<=N; j+=i) {
                isNotPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}