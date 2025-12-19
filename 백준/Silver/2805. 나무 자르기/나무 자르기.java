import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int maxTree = 0;

        // 최댓값 구하기 
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxTree) maxTree = trees[i];
        }

        // 이분탐색
        long low = 0; // 최소높이
        long high = maxTree; // 최대높이
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (int i=0; i<N; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }

            if (sum >= M) {
                answer = mid; // 일단 저장해놓기(최댓값으로 구하라고 했으니까 저장하면서 근사치 넣어두기)
                low = mid + 1; // 나무가 M보다 큼 - 더 큰쪽으로 범위를 좁혀서 더 큰값으로 빼서 근사치 만들기 
            } 
            else {
                high = mid - 1; // 나무가 부족함 - 더 작은쪽으로 범위를 좁혀서 더 작은값으로 빼서 근사치 만들기
            }
        }

        System.out.println(answer);
    }
}