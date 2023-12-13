import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testOffByN(){
        CharacterComparator offby4 = new OffByN(4);
        assertTrue(offby4.equalChars('a','e'));
        assertFalse(offby4.equalChars('a','a'));
    }

}
