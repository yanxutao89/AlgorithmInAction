package others;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        List<Character> list = new ArrayList<>(s.length());
        for(int ii = 0; ii < s.length(); ii++){
            list.add(s.charAt(ii));
        }
        String tmp = s;
        int count = 0;
        while(tmp.length() > 0){
            if(tmp.charAt(0) == '('){
                int left = tmp.indexOf('('), right = tmp.lastIndexOf(')');
                if(left < right){
                    list.remove(tmp.indexOf('('));
                    list.remove(tmp.lastIndexOf(')') - 1);
                    StringBuffer sb = new StringBuffer();
                    for(int jj = 0; jj < list.size(); jj++)
                        sb.append(list.get(jj));
                    tmp = sb.toString();
                    count += 2;
                    continue;
                }else{
                    return false;
                }
            }
            if(tmp.charAt(0) == '['){
                int left = tmp.indexOf("["), right = tmp.lastIndexOf(']');
                if(left < right){
                    list.remove(tmp.indexOf('['));
                    list.remove(tmp.lastIndexOf(']') - 1);
                    StringBuffer sb = new StringBuffer();
                    for(int jj = 0; jj < list.size(); jj++)
                        sb.append(list.get(jj));
                    tmp = sb.toString();
                    count += 2;
                    continue;
                }else{
                    return false;
                }
            }
            if(tmp.charAt(0) == '{'){
                int left = tmp.indexOf('{'), right = tmp.lastIndexOf('}');
                if(left < right){
                    list.remove(tmp.indexOf('{'));
                    list.remove(tmp.lastIndexOf('}') - 1);
                    StringBuffer sb = new StringBuffer();
                    for(int jj = 0; jj < list.size(); jj++)
                        sb.append(list.get(jj));
                    tmp = sb.toString();
                    count += 2;
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(count == s.length())
            return true;
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(!isMatch(s.charAt(i), s.charAt(j)))
                return  false;
            i++;
            j--;
        }
        return true;
    }
    private static boolean isMatch(char c1, char c2){
        if(c1 == '(' && c2 == ')')
            return true;
        if(c1 == '[' && c2 == ']')
            return true;
        if(c1 == '{' && c2 == '}')
            return true;
        return false;
    }
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String s = "(([]){})";
        System.out.println(isValid(s));
    }
}
