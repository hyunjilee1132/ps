import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<String> givenStrings = new ArrayList<>();
        for (int i=0; i<n; i++) {
            givenStrings.add(sc.next());
        }

        int count = 0;
        for (int i=0; i<m; i++) {
            String str = sc.next();

            for (int j=0; j<n; j++) {
                if (givenStrings.get(j).equals(str)) count++;
            }
        }

        System.out.println(count);
    }
}