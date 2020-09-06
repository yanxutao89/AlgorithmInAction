package others;

import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Character[] tmp = {'(',')'};
        for(int i = 1; i < 2 * n - 1; i++){
            StringBuffer sb = new StringBuffer('(');
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){

                }
            }
        }
        return res;
    }

    private static boolean isWell(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    public static void main(String[] args){
        int n = 3;
        System.out.println(generateParenthesis1(n));
    }
}
