import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int wCnt = 0;
    static int bCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        grid = new int[N][N];
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                grid[y][x] = sc.nextInt();
            }
        }

        solve(0, 0, N);

        System.out.println(wCnt);
        System.out.println(bCnt);
    }

    // 메인 로직
    static void solve(int startRow, int startCol, int size) {
        if (isSame(startRow, startCol, size)) {
            if (grid[startRow][startCol] == 0) wCnt++;
            else bCnt++;
            
            return;
        }
        else {
            // 반 나눠서 그만큼 탐색하기 - 4분면으로 나눠서 각자 탐색 
            int newSize = size/2;

            solve(startRow, startCol, newSize); 
            solve(startRow+newSize, startCol, newSize); 
            solve(startRow, startCol+newSize, newSize); 
            solve(startRow+newSize, startCol+newSize, newSize); 
        }
    }

    // 일치하는지 확인하는 함수
    static boolean isSame(int startRow, int startCol, int size) {
        int targetBlock = grid[startRow][startCol];

        for (int y=startRow; y<startRow+size; y++) {
            for (int x=startCol; x<startCol+size; x++) {
                if (targetBlock != grid[y][x]) return false;
            }
        }

        return true;
    }
}