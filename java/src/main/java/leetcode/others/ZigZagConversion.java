package others;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 */

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        int tmp = 2*numRows-2;
        for(int i = 0; i < numRows; i++)
            sbs[i] = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < numRows; j++){
                if((i % tmp) == j || (i % tmp) == tmp - j)
                    sbs[j].append(s.charAt(i));
            }
        }

        for(int i = 1; i < numRows; i++)
            sbs[0].append(sbs[i]);
        return sbs[0].toString();
    }

    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }
}
