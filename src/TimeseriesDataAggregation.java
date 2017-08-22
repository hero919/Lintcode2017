import java.util.*;

public class TimeseriesDataAggregation {

    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length ; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j){
                    continue;
                }
                String a = words[i];
                String b = words[j];

                if (isPalidrone(a + b)){
                    List<Integer> answer = new ArrayList<>();
                    answer.add(i);
                    answer.add(j);
                    result.add(answer);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> palindromePairs02(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String word : words) {
            map.put(word, index++);
        }

        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            for (int j = 0; j <= length; j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                String tryFind = new StringBuilder(right).reverse().toString();
                String tryFind02 = new StringBuilder(left).reverse().toString();


                if (isPalidrone(left) && map.containsKey(tryFind) && map.get(tryFind) != i) {
                    List<Integer> r = new ArrayList<>();
                    r.add(map.get(tryFind));
                    r.add(i);
                    result.add(r);
                }
                if (isPalidrone(right) && map.containsKey(tryFind02) && map.get(tryFind02) != i && tryFind.length() != 0) {
                    List<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(map.get(tryFind02));
                    result.add(r);
                }
            }
        }
        return result;
    }

    private boolean isPalidrone(String s){
        if (s == null || s.length() == 0) {
            return true;
        }

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }




    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return -1;
        }

        if (start.length() != end.length()) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        int result = -1;
        while(!queue.isEmpty()) {
                int size = queue.size();
                result++;
                for (int i = 0 ; i < size; i++) {
                    String mostSimilar = queue.poll();
                    for (String s : bank) {
                        if (mostSimilar.equals(end)) {
                            return result;
                        }

                        if (!visited.contains(s) && canConvert(s, mostSimilar)) {
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                }
        }
        return -1;
    }

    private boolean canConvert(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int  diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }
            diff++;
        }

        return diff == 1;


    }




    public static void main(String[] args) {
        String s1 = "AACCGGTT";
        String e1 = "AACCGGTA";
        String[] bank = new String[] {
                "AACCGGTA"
        };
        TimeseriesDataAggregation t = new TimeseriesDataAggregation();
        //System.out.println(t.minMutation(s1, e1, bank));
        System.out.println(t.palindromePairs02(new String[]{
                        "abcd", "dcba"
                }));
        //System.out.println("Test");
    }
}
