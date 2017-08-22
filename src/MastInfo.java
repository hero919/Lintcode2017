import java.util.HashSet;
import java.util.Set;

public class MastInfo {
    public static String MaskEmail(String email) {
        if (email == null || email.length() == 0) {
            return "";
        }

        String[] split = email.split("@");
        Character firstChar = email.charAt(0);
        Character lastChar = split[0].charAt(split[0].length() - 1);
        String mask = "*****";
        return firstChar + mask + lastChar + "@" + split[1];
    }


    public static String MaskPhone(String phone) {
        if (phone == null || phone.length() == 0) {
            return "";
        }
        phone = phone.trim();

        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add(')');
        set.add('-');
        set.add(' ');

        String SimplifiedPhone = "";
        for (int i = 0; i < phone.length(); i++) {
            if (set.contains(phone.charAt(i))) {
                continue;
            }
            SimplifiedPhone += phone.charAt(i);
        }



        // Last 4 should always show up
        String lastFour = SimplifiedPhone.substring(SimplifiedPhone.length() - 4, SimplifiedPhone.length());
        String middle = "***-***-";
        if (SimplifiedPhone.length() == 10) {
            return middle + lastFour;
        }

        String firstPart = "";
        for (int i = 0; i < SimplifiedPhone.length() - 11; i++) {
            if (phone.charAt(i) == '+') {
                firstPart = firstPart + phone.charAt(i);
            }

            firstPart += '*';
        }
        return firstPart + "-" + middle + lastFour;
    }







    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        System.out.println(MaskEmail("jackAndJill@gmail.com"));
        System.out.println(MaskPhone("(333)456-5678"));

    }




}
