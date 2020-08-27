/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class sword58 {


    public String reverseLeftWords(String s, int n) {
        if(s == null||s.length() == 0){
            return s;
        }
        // 获取真实长度
        int trueLength  = n%s.length();
        String subStr = s.substring(0,trueLength);
        String tailStr = s.substring(trueLength);
        return tailStr+subStr;


    }
}
