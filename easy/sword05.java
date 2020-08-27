/**
 * 剑指 Offer 05. 替换空格
 */
public class sword05 {


    public String replaceSpace(String s) {
        return s.replace(" ", "%20");

    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new sword05().replaceSpace(s));
    }
}
