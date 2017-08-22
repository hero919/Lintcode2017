public class Aug02 {


    public static int board(String[] str,int m,int n) {
        if (str == null || str.length == 0) {
            return 0;
        }

        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MAX_VALUE;
        for (String s: str) {
            int x = Integer.valueOf(s.split("\\*")[0]);
            int y = Integer.valueOf(s.split("\\*")[1]);
            maxX = Math.min(maxX, x);
            maxY = Math.max(maxY, y);
        }

        return maxX * maxY;

    }

    static String reducedFractionHelper(String a){
        if (a == null || a.length() == 0) {
            return "";
        }


        String left = a.split("\\+")[0];
        String right = a.split("\\+")[1];

        String leftTop = left.split("\\/")[0];
        String leftBot = left.split("\\/")[1];

        String rightTop = left.split("\\/")[0];
        String rightBot = right.split("\\/")[1];

        int rawTop = Integer.valueOf(leftTop) * Integer.valueOf(rightBot) +
                Integer.valueOf(rightTop) * Integer.valueOf(leftBot);

        int rawBot = Integer.valueOf(leftBot) * Integer.valueOf(rightBot);

        int gcd = getGcd(rawTop, rawBot);

        if (rawTop == 0){
            return "0";
        }

        String result = (rawTop/gcd) + "/" + (rawBot/gcd);
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
        System.out.println("Test");
    }
}
