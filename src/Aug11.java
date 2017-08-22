import java.util.HashMap;

public class Aug11 {

    public boolean determineTriangle(int a, int b, int c) {
        int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int middle = a + b + c - min - max;
        if (min <= 0) {
            return false;
        }

        if (min == max) {
            return true;
        }

        if (min + middle > max && (middle == max || middle == min)) {
            return true;
        }

        if (min + middle > min) {
            return true;
        }

        return false;
    }


//    public boolean twinString(String a, String b) {
//
//
//
//    }
//
//
//    private HashMap<Integer, Integer> constructHashMap(String s){
//        if (s == null || s.length() == 0) {
//            return null;
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (Character c : s.toCharArray()) {
//            if (map.containsKey(c)) {
//                map.put(c, map.get(c) + 1);
//            }
//
//        }
//    }



    public int LongestPhraseInATweet(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        return 1;


    }




    private int getLengthHelper() {
        return 1;



    }






    public static void main(String[] args) {
        System.out.println("Test");
    }

}
