public class OffByN implements CharacterComparator{
    private int digits;
    public OffByN(int N){
        digits = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        return Math.abs(x - y) == digits;
    }
}
