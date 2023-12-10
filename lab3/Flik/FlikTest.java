import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void TestisSameNumber(){
        assertFalse(Flik.isSameNumber(127, 126));
        assertTrue(Flik.isSameNumber(500, 500));
        assertTrue(Flik.isSameNumber(128, 128));

    }
}
