import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> targetSet = new HashSet<>();
        for (int i=0; i<n; i++) {
            targetSet.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> numList = new ArrayList<>();
        for (int i=0; i<m; i++) {
            numList.add(sc.nextInt());
        }

        for (int num : numList) {
            if (targetSet.contains(num)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    } 
}