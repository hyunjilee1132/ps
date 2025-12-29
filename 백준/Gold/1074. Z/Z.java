import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int size = 1 << N; // 2의 N승
        int count = 0;

        while (size > 1) { // 쪼갤 수 있을때까지 쪼개기 
            size /= 2;

            // 사분면
            if (r < size && c < size) continue; // 1사분면: 좌표 변화X
            else if (r < size && c >= size) {
                count += size * size; // 1사분면 개수만큼 더해주기
                c -= size; // 2사분면: 행은 그대로, 열은 변동 - 그만큼 빼줘서 보정해주기 
            }
            else if (r >= size && c < size) {
                count += (size * size) * 2; // 1, 2사분면 개수만큼 더해주기
                r -= size; // 3사분면: 열은 그대로, 행은 변동
            }
            else {
                count += (size * size) * 3; // 1, 2, 3사분면 개수만큼 더해주기
                r -= size;
                c -= size;
            }
        }

        System.out.println(count);
    }
}