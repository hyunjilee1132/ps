import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] splitInput = input.split("-"); // 55, 50+40
        for (int i=0; i<splitInput.length; i++) { // 50+40
            int sum = 0;
            String[] splitByPlus = splitInput[i].split("\\+");
            for (int j=0; j<splitByPlus.length; j++) {
                sum += Integer.parseInt(splitByPlus[j]);
            }
            splitInput[i] = Integer.toString(sum);
        }
        
        int result = Integer.parseInt(splitInput[0]);
        for (int i=1; i<splitInput.length; i++) {
            result -= Integer.parseInt(splitInput[i]);
        }

        System.out.println(result);
    }
}