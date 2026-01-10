import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 10진수
        int B = sc.nextInt(); // 변환할 진법
        
        StringBuilder sb = new StringBuilder();
        
        while (N > 0) {
            int remainder = N % B;
            
            if (remainder < 10) {
                // 0~9 사이인 경우 숫자 그대로 추가
                sb.append(remainder);
            } else {
                // 10~35 사이인 경우 알파벳 A~Z로 변환
                // 'A'의 아스키 코드에 (나머지 - 10)을 더함
                sb.append((char) (remainder - 10 + 'A'));
            }
            
            N /= B;
        }
        
        // 나머지가 낮은 자릿수부터 쌓였으므로 뒤집어서 출력
        System.out.println(sb.reverse().toString());
    }
}