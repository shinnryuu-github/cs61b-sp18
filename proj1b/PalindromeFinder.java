/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        Palindrome palindrome = new Palindrome();
        int max = 0, maxn = 1;
        for (int i = 1; i <= 25; i++) {
            CharacterComparator offbyn = new OffByN(i);
            int sum = 0;
            In in = new In("../library-sp18/data/words.txt");
            while (!in.isEmpty()) {
                String word = in.readString();
                if (word.length() >= minLength && palindrome.isPalindrome(word, offbyn)) {
                    sum++;
                }
            }
            if (sum > max) {
                max = sum;
                maxn = i;
            }
        }
        System.out.println(max + " " + maxn);
    }
}
