package others;


public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        String str = String.valueOf(num);
        int len = str.length();
        Double[] factors = new Double[len];
        int index = len - 1;
        for(int i = 0; i < len; i++){
            char tmpChar = str.charAt(i);
            double tmpInt = Integer.parseInt(Character.toString(tmpChar)) * Math.pow(10, index);
            factors[i] = tmpInt;
            if(index == 3){
                for(int j = 0; j < factors[i] / 1000; j++)
                    sb.append('M');
            }
            if(index == 2){
                if(factors[i] <= 300.0){
                    for(int l = 0; l < factors[i] / 100; l++)
                        sb.append('C');
                }else if(factors[i] == 400.0){
                    sb.append('C').append('D');
                }else if(factors[i] <= 800.0){
                    sb.append('D');
                    for(int l = 0; l < factors[i] / 100 - 5; l++)
                        sb.append('C');
                }else{
                    sb.append('C').append('M');
                }
            }
            if(index == 1){
                if(factors[i] <= 30.0){
                    for(int l = 0; l < factors[i] / 10; l++)
                        sb.append('X');
                }else if(factors[i] == 40.0){
                    sb.append('X').append('L');
                }else if(factors[i] <= 80.0){
                    sb.append('L');
                    for(int l = 0; l < factors[i] / 10 - 5; l++)
                        sb.append('X');
                }else{
                    sb.append('X').append('C');
                }
            }
            if(index == 0){
                if(factors[i] <= 3.0){
                    for(int l = 0; l < factors[i]; l++)
                        sb.append('I');
                }else if(factors[i] == 4.0){
                    sb.append('I').append('V');
                }else if(factors[i] <= 8.0){
                    sb.append('V');
                    for(int l = 0; l < factors[i] - 5; l++)
                        sb.append('I');
                }else{
                    sb.append('I').append('X');
                }
            }
            index--;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Integer num = 1994;
        System.out.println(intToRoman(num));
    }
}
