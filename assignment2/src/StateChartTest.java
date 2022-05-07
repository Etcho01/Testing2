import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Nested; import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateChartTest {

    @Nested
    class EdgeCoverage{

        StateChart mainObj;

        @BeforeEach
        public void setup(){
            mainObj = new StateChart();
        }

        @Test
        public void Test0(){
            String[] res = mainObj.input('a'); assertEquals("NORMAL", res[0]); assertEquals("DATE", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void Test1(){ mainObj.input('a');
            String[] res = mainObj.input('a'); assertEquals("NORMAL", res[0]); assertEquals("TIME", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void Test2(){ mainObj.input('a');
            mainObj.input('a');
            String[] res = mainObj.input('c'); assertEquals("UPDATE", res[0]); assertEquals("min", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void Test3(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("min", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void Test4(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("hour", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void Test5(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("hour", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test6(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("day", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test7(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');

            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("day", res[1]); assertEquals("2000-1-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test8(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("month", res[1]); assertEquals("2000-1-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test9(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("month", res[1]); assertEquals("2000-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test10(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('a');
            assertEquals("UPDATE", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2000-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test11(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("year", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test12(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("NORMAL", res[0]); assertEquals("TIME", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test13(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');

            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('c'); assertEquals("UPDATE", res[0]); assertEquals("min", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test14(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('c');
            String[] res = mainObj.input('d'); assertEquals("NORMAL", res[0]); assertEquals("TIME", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test15(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('d');
            String[] res = mainObj.input('b'); assertEquals("ALARM", res[0]); assertEquals("Alarm", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }


        @Test
        public void Test16(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('d');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("ALARM", res[0]); assertEquals("Chime", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

        @Test
        public void Test17(){ mainObj.input('a');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('c');
            mainObj.input('d');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('d'); assertEquals("NORMAL", res[0]); assertEquals("TIME", res[1]); assertEquals("2001-2-2", res[2]);
            assertEquals("1:1", res[3]);
        }

    }


    @Nested class ADUP{


        StateChart mainObj;

        @BeforeEach
        public void setup(){
            mainObj = new StateChart();
        }

        @Test
        public void ADUPTest0(){
            String[] res = mainObj.input('c'); assertEquals("UPDATE", res[0]); assertEquals("min", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:0", res[3]);
        }

        @Test
        public void ADUPTest1(){ mainObj.input('c');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("min", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:1", res[3]);
        }

        @Test
        public void ADUPTest2(){ mainObj.input('c');
            mainObj.input('b');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("min", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:2", res[3]);
        }

        @Test
        public void ADUPTest3(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("hour", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("0:2", res[3]);
        }

        @Test
        public void ADUPTest4(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b');

            assertEquals("UPDATE", res[0]); assertEquals("hour", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("1:2", res[3]);
        }

        @Test
        public void ADUPTest5(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("hour", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest6(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("day", res[1]); assertEquals("2000-1-1", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest7(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("day", res[1]); assertEquals("2000-1-2", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest8(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');

            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("day", res[1]); assertEquals("2000-1-3", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest9(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("month", res[1]); assertEquals("2000-1-3", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest10(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("month", res[1]); assertEquals("2000-2-3", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest11(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');

            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("month", res[1]); assertEquals("2000-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest12(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            String[] res = mainObj.input('a'); assertEquals("UPDATE", res[0]); assertEquals("year", res[1]); assertEquals("2000-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest13(){ mainObj.input('c');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            String[] res = mainObj.input('b'); assertEquals("UPDATE", res[0]); assertEquals("year", res[1]); assertEquals("2001-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }

        @Test
        public void ADUPTest14(){ mainObj.input('c');

            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            mainObj.input('b');
            mainObj.input('a');
            mainObj.input('b');
            String[] res = mainObj.input('b');
            assertEquals("UPDATE", res[0]);
            assertEquals("year", res[1]);
            assertEquals("2002-3-3", res[2]);
            assertEquals("2:2", res[3]);
        }

    }

}
