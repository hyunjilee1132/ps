import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Set<String> wordSet = new HashSet<>();
        for (int i=0; i<n; i++) {
            wordSet.add(sc.next());
        }

        List<String> wordList = new ArrayList<>(wordSet);

        List<word> wordListToWord = new ArrayList<>();
        for (int i=0; i<wordList.size(); i++) {
            wordListToWord.add(new word(wordList.get(i)));
        }

        Collections.sort(wordListToWord);

        for (word word : wordListToWord) {
            System.out.println(word);
        }
    }

    static class word implements Comparable<word> {
        String input;

        word (String input) {
            this.input = input;
        }

        @Override
        public int compareTo(word other) {

            // 길이
            if (this.input.length() != other.input.length()) {
                return this.input.length() - other.input.length();
            }

            // 사전순
            return this.input.compareTo(other.input);
        }

        @Override
        public String toString() {
            return input;
        }
    } 
}