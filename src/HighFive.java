import java.util.*;

// Definition for a Record
  class Record {
      public int id, score;
      public Record(int id, int score){
          this.id = id;
          this.score = score;
      }
  }






public class HighFive {
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> result = new HashMap<>();
        if (results == null || results.length == 0) {
            return result;
        }

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (Record r : results) {
            if (map.containsKey(r.id)) {
                map.get(r.id).add(r.score);
            }else {
                PriorityQueue<Integer> queue = new PriorityQueue<>(5, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                queue.add(r.score);
                map.put(r.id, queue);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> e: map.entrySet()) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += e.getValue().poll();
            }
            double ave = sum / 5.0;
            result.put(e.getKey(), ave);
        }

        return result;
    }





    public static void main(String[] args) {
        System.out.println("Test");
        System.out.println((double) 2/ 5);
    }
}
