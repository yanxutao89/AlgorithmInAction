package others;

/**Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 */

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        int a = Math.abs(dividend), b = Math.abs(divisor);
        if(a - b < 0)
            return 0;
        if(b == 1)
            if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
                return -dividend + 1;
            else
                return dividend - 1;
        int count = 1;
        if(a - b < b && a - b > -1){
            if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
                return -count;
            else
                return count;
        }
        int tmp = a - b;
        while(tmp > b){
            count++;
            tmp = tmp - b;
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            return -count;
        else
            return count;
    }
    public static void main(String[] args){
        int dividend = -2147483648, divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
}
