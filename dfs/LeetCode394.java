/**
 * 394. 字符串解码
 */
public class LeetCode394 {
    String src;
    int ptr;

    public String decodeString(String s) {
        src=s;
        ptr=0;
        return getString();

    }

    public String getString() {
        // 递归终止条件
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }
        char cur = src.charAt(ptr);
        int num = 0;
        String ret = "";
        if (Character.isDigit(cur)) {
            num = getDigits();
            // 过左括号
            ptr++;
            // 括号内的字符串当做新的字符串处理
            String str = getString();
            // 过右括号
            ptr++;
            // 解码
            while (num-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            ret = String.valueOf(src.charAt(ptr++));
        }
        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
