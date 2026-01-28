import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong(); // 밑
        long B = sc.nextLong(); // 지수
        long C = sc.nextLong(); // 나누는 수

        long result = 1;

        // 지수가 너무 큼 - 쪼개서 생각하기(10의 11승: 10의 2승*5개+10의 1승, 100%12==4, 4*4*4*4*4*10)
        while (B > 0) {
            // 지수가 홀수면 남는 1개는 먼저 넣어주고 시작
            if (B % 2 == 1) {
                result = (result * A) % C;
            }
            
            A = (A * A) % C; // 작게 계산하고 그것도 C로 나눈 나머지만 챙기기
            B = B / 2;
        }

        System.out.println(result);
    }
}