package others;

public class StringToIntegerATOI {
        public static int myAtoi(String str) {
            double res;
            if(str.length() == 0 || str.replaceAll(" ", "").length() ==0 || (str.length() > 2 && str.charAt(0) == '-' && str.charAt(1) == '+') || str == "-" || str == "+")
                return 0;
            str = str.replaceAll(" ", "");
            if(!isNumeric(str.charAt(0)) && str.charAt(0) != '-')
                return 0;
            if(str.charAt(0) == '-')
                str = str.substring(1);
            int dot = str.indexOf(".");
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                if(dot !=- 1){
                    if(isNumeric(str.charAt(i)) || str.charAt(i) == '.')
                        count++;
                    else
                        break;
                }else {
                    if (isNumeric(str.charAt(i))) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            str = str.substring(0, count);
            if(count == 0)
                return 0;
            if(count < str.length())
                str = str.substring(0, count + 1);
            res = strToNum(str, dot);
            if(res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int)res;

        }
    private static double strToNum(String str, int dot){
        double res = 0, indexPos, indexNeg;
        if(dot == -1){
            dot = str.length();
            indexPos = dot - 1;
            indexNeg = 0;
        }else{
            indexPos = str.length() - dot -2;
            indexNeg = -1;
        }
        for(int i = 0; i < str.length(); i++){
            if(i < dot){
                res += Integer.parseInt(Character.toString(str.charAt(i))) * Math.pow(10, indexPos);
                indexPos--;
            }else if(i == dot){
                continue;
            }else {
                res += Integer.parseInt(Character.toString(str.charAt(i))) * Math.pow(10, indexNeg);
                indexNeg++;
            }
        }
        return res;
    }
    private static boolean isNumeric(char c){
        if(c > '0' && c < '9')
            return true;
        return false;
    }

    public static void main(String[] args){
        String str = " -42";
        System.out.println(myAtoi(str));
    }
}
