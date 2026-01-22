import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int sum = 0;
    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static int[] arr;
    static int[] ops = new int[4]; // 사칙연산자 개수
    static ArrayList<String> expression = new ArrayList<>(); // dfs로 만든 수식 <2, +, 3, *, 4>

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = sc.nextInt();
        for (int i=0; i<4; i++) ops[i] = sc.nextInt();

        expression.add(String.valueOf(arr[0]));

        dfs(1, ops[0], ops[1], ops[2], ops[3]);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    // 문자 하나씩 반환 - 리스트에 넣어서 - 수식 만들기 
    static void dfs(int idx, int plus, int minus, int multi, int div) {
        if (idx == n) {
            int result = getResult();
            maxVal = Math.max(maxVal, result);
            minVal = Math.min(minVal, result);
            return;
        }

        if (plus > 0) {
            expression.add("+");
            expression.add(String.valueOf(arr[idx]));
            dfs(idx+1, plus-1, minus, multi, div);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);   
        }
        if (minus > 0) {
            expression.add("-");
            expression.add(String.valueOf(arr[idx]));
            dfs(idx+1, plus, minus-1, multi, div);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);  
        }
        if (multi > 0) {
            expression.add("*");
            expression.add(String.valueOf(arr[idx]));
            dfs(idx+1, plus, minus, multi-1, div);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);  
        }
        if (div > 0) {
            expression.add("/");
            expression.add(String.valueOf(arr[idx]));
            dfs(idx+1, plus, minus, multi, div-1);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);  
        }
    }

    static int getResult() {
        ArrayList<String> tmp = new ArrayList<>(expression);

        // */
        for (int i=0; i<tmp.size();) {
            String s = tmp.get(i);
            if (s.equals("*") || s.equals("/")) {
                int left = Integer.parseInt(tmp.get(i-1));
                int right = Integer.parseInt(tmp.get(i+1));
                int result = s.equals("*") ? left * right : left / right;

                tmp.remove(i + 1);
                tmp.remove(i);
                tmp.set(i - 1, String.valueOf(result)); // 연산자랑 right 제거하고, 가장 왼쪽에 계산한 값 넣기
            }
            else i++; // 둘다 아니면 건너뛰기
        }

        int finalResult = Integer.parseInt(tmp.get(0));
        for (int i=1; i<tmp.size(); i+=2) {
            String op = tmp.get(i);
            int nextNum = Integer.parseInt(tmp.get(i+1));
            if (op.equals("+")) finalResult += nextNum;
            else finalResult -= nextNum;
        }

        return finalResult;
    }
}