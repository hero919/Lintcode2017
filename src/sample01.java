public class sample01 {
    static String reducedFractionHelper(String a){
        if (a == null || a.length() == 0) {
            return "";
        }


        String left = a.split("\\+")[0];
        String right = a.split("\\+")[1];

        String leftTop = left.split("/")[0];
        String leftBot = left.split("/")[1];

        String rightTop = right.split("/")[0];
        String rightBot = right.split("/")[1];


        String rawResult = (Integer.valueOf(leftTop) * Integer.valueOf(rightBot) + Integer.valueOf(rightTop) * Integer.valueOf(leftBot)) + "/" + (Integer.valueOf(leftBot) * Integer.valueOf(rightBot));

        int gcd = getGcd(Integer.valueOf(rawResult.split("/")[0]), Integer.valueOf(rawResult.split("/")[1]));
        String result = (Integer.valueOf(rawResult.split("/")[0]) / gcd ) + "/" + (Integer.valueOf(rawResult.split("/")[1])/ gcd);
        return result;
    }

    static int getGcd(int a, int b){
        while(a % b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(reducedFractionHelper("722/148+360/176"));
    }
}
