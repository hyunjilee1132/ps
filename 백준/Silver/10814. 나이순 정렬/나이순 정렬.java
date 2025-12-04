import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<pair> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new pair(age, name));
        }

        Collections.sort(list);

        for (int i=0; i<n; i++) {
            System.out.println(list.get(i));
        }
    }

    static class pair implements Comparable<pair> {
        int age;
        String name;

        pair (int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(pair other) {

            if (this.age != other.age) {
                return this.age - other.age;
            }
            return 0;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    } 
}