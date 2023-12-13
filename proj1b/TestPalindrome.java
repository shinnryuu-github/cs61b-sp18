import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        String s1 = "amanaplanacanalpanama";
        String s2 = "";
        String s3 = "a";
        String s4 = "raceacar";
        assertTrue(palindrome.isPalindrome(s1));
        assertTrue(palindrome.isPalindrome(s2));
        assertTrue(palindrome.isPalindrome(s3));
        assertFalse(palindrome.isPalindrome(s4));
    }

    @Test
    public void testisnewPalindrome(){
        String s1 = "fmanmbne";
        String s2 = "";
        String s3 = "a";
        String s4 = "amanaplanacanalpanama";
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(s1, cc));
        assertTrue(palindrome.isPalindrome(s2, cc));
        assertTrue(palindrome.isPalindrome(s3, cc));
        assertFalse(palindrome.isPalindrome(s4, cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
    }
}
