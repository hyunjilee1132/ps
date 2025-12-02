import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String str = sc.nextLine();

            if (str.equals("0")) return;

            boolean isPal = true;
            int mid = str.length() / 2;
            for (int i=0; i<mid; i++) {
                if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                    isPal = false;
                    break;
                }
            }
            
            if (isPal) System.out.println("yes");
            else System.out.println("no");
        }
    }
}