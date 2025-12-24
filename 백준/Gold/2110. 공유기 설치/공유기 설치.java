import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static long[] homes;
    static int N, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 집의 개수
        C = sc.nextInt(); // 공유기의 개수

        homes = new long[N];
        for (int i=0; i<N; i++) {
            homes[i] = sc.nextLong();
        }

        Arrays.sort(homes);

        long left = 1; // 간격의 최솟값
        long right = homes[N-1] - homes[0]; // 간격의 최댓값 
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isValid(mid)) {
                result = mid; // 일단 넣어놓고 더 큰 수 나오면 갱신 
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean isValid(long gap) {
        int count = 1; // 설치된 공유기 수
        long lastInstalled = homes[0]; // 첫번째 집 좌표

        for (int i=1; i<N; i++) {
            if (homes[i] - lastInstalled >= gap) {
                count++; // 조건에 맞으면 설치
                lastInstalled = homes[i]; // 공유기 설치 장소를 현재 위치로 갱신
            }
        }

        if (count >= C) return true;
        else return false;
    }
}