import org.junit.Test;
import static org.junit.Assert.*;

public class CheckEvenOddTest {
    @Test
    public void Even1(){
        CheckEvenOdd x = new CheckEvenOdd(); int n = 6; assertEquals("Even",x.check(n));
    }
    @Test
    public void Odd1(){
        CheckEvenOdd x = new CheckEvenOdd(); int n = 9; assertEquals("Odd",x.check(n));
    }
    @Test
    public void Even2(){
        CheckEvenOdd x = new CheckEvenOdd(); int n = 40; assertEquals("Even",x.check(n));
    }
    @Test
    public void Odd2(){
        CheckEvenOdd x = new CheckEvenOdd(); int n = 43; assertEquals("Odd",x.check(n));
    }
    @Test
    public void ZeroIsEven(){
        CheckEvenOdd x = new CheckEvenOdd();
        int n = 0;
        assertEquals("Even",x.check(n));
    }
    @Test(expected = IllegalArgumentException.class) public void negative(){
        CheckEvenOdd x = new CheckEvenOdd(); int n = -4;
        x.check(n);
    }
}
