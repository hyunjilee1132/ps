import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] result;
    
    // 입출력 시간초과
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        result = new int[m];

        back(0);

        System.out.println(sb);
    }

    static void back(int depth) {
        // 종료: m개를 다 뽑았을때
        if (depth == m) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 중복순열은 방문여부 필요X
        for (int i=0; i<n; i++) {
            result[depth] = arr[i];
            back(depth+1);
        }
    }
} 