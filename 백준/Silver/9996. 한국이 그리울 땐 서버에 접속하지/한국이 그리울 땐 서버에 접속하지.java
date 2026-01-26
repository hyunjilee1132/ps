import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String pattern = sc.next(); // ab * cd
        String[] patternSet = pattern.split("\\*"); // ["ab", "cd"]

        for (int i=0; i<n; i++) {
            String str = sc.next();

            if (str.length() < patternSet[0].length() + patternSet[1].length()) System.out.println("NE"); // abc*cde == abccde, != abcde
            else if (str.startsWith(patternSet[0]) && str.endsWith(patternSet[1])) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}

// 패턴은 알파벳 소문자 여러 개와 별표(*) 하나로 이루어진 문자열