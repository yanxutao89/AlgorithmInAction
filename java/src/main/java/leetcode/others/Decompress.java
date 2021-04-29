package leetcode.others;

public class Decompress {

    public String decompress(String compressed) {
        StringBuilder sb = new StringBuilder();
        char[] chars = compressed.toCharArray();

        recurse(chars, 0, 0, 0, sb, new StringBuilder());
        return sb.toString();
    }

    private void recurse(char[] chars, int index, int count, int num, StringBuilder sb, StringBuilder sb2) {
        if (index == chars.length) {
            return;
        }
        char c = chars[index];
        if (c >= '0' && c <= '9') {
            count = Integer.valueOf(c + "");
        }
        else if (c == '[') {
            ++num;
        }
        else if (c == ']') {
            --num;
            for (int i = 0; i < count; ++i) {
                sb.append(sb2.toString());
            }
            count = 0;
        }
        else {
            sb2.append(c);
        }
        if (num == 0) {
            recurse(chars, index + 1, num, count, sb, sb2);
        }
    }

    public static void main(String[] args) {
        String compressed = "2[A3[C]]";
        System.out.println(new Decompress().decompress(compressed));
    }

}
