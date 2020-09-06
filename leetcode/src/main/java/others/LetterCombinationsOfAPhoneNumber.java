package others;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        int sum = 1;
        int len = digits.length();
        if(len == 0 || digits == "")
            return new ArrayList<>();
        int[] index = new int[len];
        for(int i = 0; i < len; i++){
            if(digits.charAt(i) == '7' || digits.charAt(i) == '9'){
                index[i] = 4;
                sum *= 4;
            }else{
                index[i] = 3;
                sum *= 3;
            }
        }
        List<String> res =  new ArrayList<>(sum);
        List<String> tmpPre = divideDigit(digits.charAt(0));
        if(len == 1)
            return tmpPre;
        int count = 1;
        int pos = 0;
        while(count < len){
            List<String> tmpAft = divideDigit(digits.charAt(count));
            for(int i = 0; i < (count > 1 ? tmpPre.size() : index[0]); i++){
                for(int j = 0; j < index[count]; j++){
                    res.add(pos, tmpPre.get(i) + tmpAft.get(j));
                    pos++;
                }
            }
            tmpPre.clear();
            tmpPre.addAll(res);
            pos = 0;
            if(count < len - 1)
                res.clear();
            count++;
        }
        return res;
    }

    private static List<String> divideDigit(char num){
        List<String> res = new ArrayList<>();
        char c1 = num;
        if(c1 >= '2' && c1 <= '6'){
            int tmp = Character.getNumericValue(c1);
            tmp = tmp + 2 * (tmp - 2);
            res.add(String.valueOf((char)(tmp + 95)));
            res.add(String.valueOf((char)(tmp + 96)));
            res.add(String.valueOf((char)(tmp + 97)));
        }else if(c1 == '7') {
            int tmp = Character.getNumericValue(c1);
            res.add(String.valueOf((char)(tmp + 105)));
            res.add(String.valueOf((char)(tmp + 106)));
            res.add(String.valueOf((char)(tmp + 107)));
            res.add(String.valueOf((char)(tmp + 108)));
        }else if(c1 == '8'){
            int tmp = Character.getNumericValue(c1);
            res.add(String.valueOf((char)(tmp + 108)));
            res.add(String.valueOf((char)(tmp + 109)));
            res.add(String.valueOf((char)(tmp + 110)));
        }else{
            int tmp = Character.getNumericValue(c1);
            res.add(String.valueOf((char)(tmp + 110)));
            res.add(String.valueOf((char)(tmp + 111)));
            res.add(String.valueOf((char)(tmp + 112)));
            res.add(String.valueOf((char)(tmp + 113)));
        }
        return res;
    }
    public static void main(String[] args){
        String digits = "5678";
        System.out.println(letterCombinations(digits));
        System.out.println(divideDigit('5'));
    }
}
