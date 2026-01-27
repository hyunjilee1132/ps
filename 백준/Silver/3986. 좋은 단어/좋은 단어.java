import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            
            Stack<Character> stack = new Stack<>();
            
            for (char c : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop(); 
                } else {
                    stack.push(c); 
                }
            }
            
            if (stack.isEmpty()) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}