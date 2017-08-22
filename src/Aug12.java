import java.util.*;

public class Aug12 {

    public List<Integer> TwitterRecommandation(List<int[]> followGraph, List<int[]> likeGraph, int targetUser, int minLike) {
        //Base Check


        HashMap<Integer, List<Integer>> lGraph = new HashMap<>();
        for (int[] array: likeGraph) {
            if (lGraph.containsKey(array[0])) {
                lGraph.get(array[0]).add(array[1]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(array[1]);
                lGraph.put(array[0], list);
            }
        }

        List<Integer> following = new ArrayList<>();
        for (int[] array: followGraph) {
            if (array[0] == targetUser) {
                following.add(array[1]);
            }
        }
        //System.out.println(following);

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        for (Integer i : following) {
            if (!lGraph.containsKey(i)){
                continue;
            }
            for (Integer e : lGraph.get(i)) {
                if (map.containsKey(e)) {
                    map.put(e, map.get(e) + 1);
                }else {
                    map.put(e, 1);
                }
                if (map.get(e) >= minLike) {
                    result.add(e);
                }
            }
        }

        List<Integer> answer = new ArrayList<>(result);
        return answer;
    }








    public static void main(String[] args) {
        System.out.println("Test");
        List<int[]> followGraph = new ArrayList<>();
        int[] s1 = new int[2];
        s1[0] = 1;
        s1[1] = 2;
        int[] s2 = new int[2];
        s2[0] = 2;
        s2[1] = 3;
        int[] s3 = new int[2];
        s3[0] = 3;
        s3[1] = 1;
        int[] s4 = new int[2];
        s4[0] = 3;
        s4[1] = 4;
        int[] s5 = new int[2];
        s5[0] = 4;
        s5[1] = 2;
        int[] s6 = new int[2];
        s6[0] = 4;
        s6[1] = 1;
        followGraph.add(s1);
        followGraph.add(s2);
        followGraph.add(s3);
        followGraph.add(s4);
        followGraph.add(s5);
        followGraph.add(s6);

        Aug12 a = new Aug12();


        List<int[]> likeGraph = new ArrayList<>();
        int[] l1 = new int[2];
        l1[0] = 1;
        l1[1] = 111;
        int[] l2 = new int[2];
        l2[0] = 2;
        l2[1] = 111;
        int[] l3 = new int[2];
        l3[0] = 2;
        l3[1] = 222;
        int[] l4 = new int[2];
        l4[0] = 4;
        l4[1] = 333;
        likeGraph.add(l1);
        likeGraph.add(l2);
        likeGraph.add(l3);
        likeGraph.add(l4);



        System.out.println(a.TwitterRecommandation(followGraph, likeGraph, 4, 2));
    }
}
