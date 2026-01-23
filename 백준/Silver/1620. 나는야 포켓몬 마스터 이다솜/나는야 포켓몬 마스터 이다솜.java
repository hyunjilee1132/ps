import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, String> findByIndex = new HashMap<>(); // 번호로 찾을때
        Map<String, Integer> findByName = new HashMap<>(); // 이름으로 찾을때 

        for (int i=1; i<=n; i++) {
            String name = sc.next();

            findByIndex.put(i, name);
            findByName.put(name, i);
        }

        for (int i=0; i<m; i++) {
            String input = sc.next();
            
            // 입력값이 숫자일때
            // if ('0' <= input.charAt(0) && input.charAt(0) <= '9') { // 아스키 코드로 비교
            if (Character.isDigit(input.charAt(0))) {
                System.out.println(findByIndex.get(Integer.parseInt(input)));
            }

            // 입력값이 문자일때
            else System.out.println(findByName.get(input));
        }
    }
}