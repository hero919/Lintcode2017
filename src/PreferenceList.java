import java.util.*;

public class PreferenceList {


    public static List<Integer> getOrder(List<List<Integer>> input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.size() == 0 ) {
            return result;
        }

        Set<Integer> allNum = new HashSet<>();
        Map<Integer, Set<Integer>> order = new HashMap<>();
        for (List<Integer> l : input) {
            for(int i = 1; i < l.size(); i++) {
                int first = l.get(i - 1);
                int last = l.get(i);
                allNum.add(first);
                allNum.add(last);

                if (order.containsKey(last)) {
                    order.get(last).add(first);
                }else {
                    Set<Integer> set = new HashSet<>();
                    set.add(first);
                    order.put(last, set);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : allNum) {
            if (!order.containsKey(i)) {
                queue.add(i);
                result.add(i);
            }
        }



        while(!queue.isEmpty()) {
            Integer top = queue.poll();
            for(Map.Entry<Integer, Set<Integer>> e : order.entrySet()) {
                if (e.getValue().contains(top)) {
                    e.getValue().remove(top);
                    if (e.getValue().size() == 0) {
                        queue.add(e.getKey());
                        result.add(e.getKey());
                    }
                }
            }
        }

        return result;

    }






    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(5);
        l1.add(7);
        l1.add(9);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        l2.add(5);
        List<List<Integer>> input = new ArrayList<>();
        input.add(l1);
        input.add(l2);
        System.out.println(getOrder(input));


        System.out.println("Test");
    }
}
