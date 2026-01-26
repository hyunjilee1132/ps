import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }

        // 처음 합 만들어놓기
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += list.get(i);
        }

        int maxVal = sum;
        for (int i=1; i<=n-k; i++) {
            sum = sum - list.get(i-1) + list.get(i+k-1); // sum으로 계속 비교 - 새로운 sum이 아니라 기존의 sum 이용
            if (maxVal < sum) maxVal = sum;
        }

        System.out.println(maxVal);
    }
}

// 누적합에서 좌우로 빼고 더하기 