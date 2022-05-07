public class CheckEvenOdd { public String check(int n){
    if ( n < 0)
        throw new IllegalArgumentException("Weight must be bigger than 0");

    if(n % 2 == 0)
        return "Even";
    else
        return "Odd";
    }
}
