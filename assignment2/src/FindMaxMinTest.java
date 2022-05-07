import org.junit.Test;
import static org.junit.Assert.*; public class FindMaxMinTest {
    @Test
    public void Test0(){
        FindMaxMin y = new FindMaxMin();
        int[] x = {5};
        assertEquals(5,y.Min(x)); assertEquals(5, y.Max(x));
    }
    @Test
    public void Test1(){
        FindMaxMin y = new FindMaxMin();
        int[] x = {1,2,-2,-66,10,11,240};
        assertEquals(-66,y.Min(x)); assertEquals(240, y.Max(x));
    }
    @Test
    public void Test2(){
        FindMaxMin y = new FindMaxMin();
        int[] x = {0,1,2,0,260,7,9,999};
        assertEquals(0,y.Min(x)); assertEquals(999, y.Max(x));
    }
    @Test
    public void Test3(){
        FindMaxMin y = new FindMaxMin();
        int[] x = {1,2};
        assertEquals(1,y.Min(x)); assertEquals(2, y.Max(x));
    }
}
