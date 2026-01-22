import java.util.Scanner;

public class Main {
    static int n;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static int[] nums;
    static int[] ops; // + - x / 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        ops = new int[4];
        for (int i=0; i<4; i++) {
            ops[i] = sc.nextInt();
        }

        dfs(1, nums[0], ops[0], ops[1], ops[2], ops[3]);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    static void dfs(int idx, int currSum, int plusCnt, int minusCnt, int mulCnt, int divCnt) {
        if (idx == n) { // 종료조건: 끝까지 갔을 때(n개의 수를 다 봤을때)
            if (currSum > maxVal) maxVal = currSum;
            if (currSum < minVal) minVal = currSum;

            return;
        }

        // n-1개 이상도 가능 
        if (plusCnt > 0) {
            dfs(idx + 1, currSum + nums[idx], plusCnt - 1, minusCnt, mulCnt, divCnt);
        }
        if (minusCnt > 0) {
            dfs(idx + 1, currSum - nums[idx], plusCnt, minusCnt - 1, mulCnt, divCnt);
        }
        if (mulCnt > 0) {
            dfs(idx + 1, currSum * nums[idx], plusCnt, minusCnt, mulCnt - 1, divCnt);
        }
        if (divCnt > 0) {
            dfs(idx + 1, currSum / nums[idx], plusCnt, minusCnt, mulCnt, divCnt - 1);
        }
    }
}