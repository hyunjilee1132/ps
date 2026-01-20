import java.util.Scanner;

public class Main {
    static int n;
    static int count = 0;
    static boolean[] visitedCol;
    static boolean[] visitedLeftDiag; // 우-좌
    static boolean[] visitedRightDiag; // 좌-우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visitedCol = new boolean[n];
        visitedLeftDiag = new boolean[2 * n]; // 대각선 모두 수용하려면 2n개 필요(2n-1)
        visitedRightDiag = new boolean[2 * n];

        back(0);

        System.out.println(count);
    }

    static void back(int row) {
        // base
        if (row == n) { // 퀸을 n개만큼 놨다면
            count++; // 경우의 수 올려주기
            return;
        }

        for (int col=0; col<n; col++) {
            if (!visitedCol[col] 
                && !visitedLeftDiag[row + col] 
                && !visitedRightDiag[row - col + n]) {
                visitedCol[col] = true;
                visitedLeftDiag[row + col] = true;
                visitedRightDiag[row - col + n] = true;

                back(row + 1); // 그 다음 행으로 이동해서 체크

                // 방문은 원상복구(다른 경우 또 찾기위함)
                visitedCol[col] = false;
                visitedLeftDiag[row + col] = false;
                visitedRightDiag[row - col + n] = false;
            }
        }
    }
}