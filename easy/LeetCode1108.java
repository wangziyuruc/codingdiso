/**
 * 1108. IP 地址无效化
 */
public class LeetCode1108 {

    public static String defangIPaddr(String address) {
        if (address == null) {
            return null;
        }
        return address.replace(".", "[.]");

    }


    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));

    }
}
