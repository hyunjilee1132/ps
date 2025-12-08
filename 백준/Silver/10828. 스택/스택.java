import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Stack<String> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            String input = sc.nextLine();

            if (input.startsWith("push")) {
                stack.add(input.substring(5)); // "push " 이 다음 입력값 넣기
            }
            else if (input.equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println("-1");
                }
            }
            else if (input.equals("size")) {
                System.out.println(stack.size());
            }
            else if (input.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
            else { // top
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
