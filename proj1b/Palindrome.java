public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++){
            res.addLast(word.charAt(i));
        }
        return res;
    }

    private boolean isPalindromeH(Deque<Character> d){
        if (d.size() == 1 || d.size() == 0)
            return true;
        if (d.removeFirst() != d.removeLast())
            return false;
        return isPalindromeH(d);
    }

    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        return isPalindromeH(d);
    }

    private boolean isPalindromeH(Deque<Character> d, CharacterComparator cc){
        if (d.size() == 1 || d.size() == 0)
            return true;
        char x = d.removeFirst(), y = d.removeLast();
        if (!cc.equalChars(x, y))
            return false;
        return isPalindromeH(d, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wordToDeque(word);
        return isPalindromeH(d, cc);
    }
}
