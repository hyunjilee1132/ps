import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong(); // 이미 가지고 있는
        long N = sc.nextLong(); // 필요한 랜선의 개수

        List<Long> lines = new ArrayList<>();
        long maxValue = 0;
        for (int i=0; i<K; i++) {
            lines.add(sc.nextLong());
            if (lines.get(i) > maxValue) maxValue = lines.get(i);
        }

        long left = 1; // 0으로 나눴을때 에러 방지 
        long right = maxValue;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i=0; i<K; i++) {
                if (lines.get(i) >= mid) { // 범위때문에 틀림. =도 포함 해줘야됨
                    sum += (lines.get(i) / mid);
                }
            }

            if (sum >= N) {
                left = mid + 1; // 그래도 크다면 수를 올려서 나누기 
                result = mid; // 임시 저장 
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}