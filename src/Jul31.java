import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jul31 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummyhead = new ListNode(0);
        ListNode node = dummyhead;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
                continue;
            }

            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                continue;
            }
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        return dummyhead.next;
    }



    public static List<Integer> findHoles(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(4, 1);
        map.put(6, 1);
        map.put(0, 1);
        map.put(9, 1);
        map.put(8, 2);

        for (int i : nums) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
                continue;
            }
            result.add(0);
        }


        return result;
    }




    public static List<Integer> findHoles02(int[] nums){
        ArrayList<Integer> res=new ArrayList<Integer>();
        int[] holes={1,0,0,0,1,0,1,0,2,1};
        for(int i=0;i<nums.length;i++){
            int rst=0;
            int t=nums[i];
            if(t==0){
                rst=1;
            }else{
                while(t!=0){
                    int b=t%10;
                    rst+=holes[b];
                    t=t/10;
                }
            }
/*
String s=String.valueOf(t);
for(int j=0;j<s.length();j++){
rst+=holes[s.charAt(j)-'0'];
}*/
            res.add(rst);
        }
        return res;
    }

    public static int anagram(String a, String b) {
         int result = 0;
         if (a == null || b == null) {
             return -1;
         }

         if (a.length() != b.length()) {
             return -1;
         }

         int[] map = new int[26];
         for (Character c : a.toCharArray()) {
             map[c - 'a']++;
         }

         for (Character c: b.toCharArray()) {
             if (map[c - 'a'] != 0) {
                 map[c - 'a']--;
                 continue;
             }
             result++;
         }
         return result;
    }

    public static int board(String[] str,int m,int n) {
        if (str == null || str.length == 0) {
            return m * n;
        }
        int maxValue = 0;
        int result = 0;

        int[][] map = new int[n][m];

        for (String s : str) {
            int step = Integer.valueOf(s);
            for (int i = 0; i < step / 10; i++){
                for (int j = 0; j < step % 10; j++) {
                    map[j][i]++;
                    maxValue = Math.max(maxValue, map[j][i]);
                }
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (map[j][i] == maxValue) {
                    result++;
                }
            }
        }
        return result;
    }



    private static int gcd(int a, int b){
        if (a % b != 0){
            return gcd(b, a % b);
        }

        return b;
    }

    private static int gcd2(int a, int b) {
        while (a % b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return b;
    }



    public static String addFraction(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] array = s.split("\\+");
        String left = array[0];
        String right = array[1];

        String leftTop = (left.split("/"))[0];
        String leftBot = (left.split("/"))[1];

        String rightTop = (right.split("/"))[0];
        String rightBot = (right.split("/"))[1];

        String rawResult = (Integer.valueOf(leftTop) * Integer.valueOf(rightBot) + Integer.valueOf(rightTop) * Integer.valueOf(leftBot)) + "/" + (Integer.valueOf(leftBot) * Integer.valueOf(rightBot));
        int gcd = gcd(Integer.valueOf(rawResult.split("/")[0]), Integer.valueOf(rawResult.split("/")[1]));
        String result = (Integer.valueOf(rawResult.split("/")[0]) / gcd ) + "/" + (Integer.valueOf(rawResult.split("/")[1])/ gcd);
        return result;
    }

        public static void main(String[] args) {
        System.out.println(findHoles02(new int[]{
                1,2,4,8
        }));

        System.out.println(findHoles(new int[]{
                1,2,4,8
        }));
//
//        System.out.println(anagram("aabc", "abcd"));
//
//        System.out.println(addFraction("16/3+12/5"));
//        System.out.println(addFraction("1/2+1/3"));
        System.out.println(addFraction("1/2+1/2"));

            System.out.println(gcd(15, 12));
            System.out.println(gcd2(15, 12));

        }
}
