import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); // 주어진 문자열의 길이
        String str = sc.next(); // 주어진 문자열 

        int count = 0;
        int repeat = 0; 

        for (int i=1; i<m-1; i++) { // IOIOIOI
            if (str.charAt(i-1)=='I' && str.charAt(i)=='O' && str.charAt(i+1)=='I') {
                repeat++;

                if (repeat == n) {
                    count++;
                    repeat--; 
                }
                
                i++;
            } else {
                repeat = 0;
            }
        }

        System.out.println(count);
    }
}