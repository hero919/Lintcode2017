import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


 class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }

 }



public class Aug09 {

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here

        class pointComparator implements Comparator<Point> {

            @Override
            public int compare(Point o1, Point o2) {
                double d1 = getDistance(o1, origin);
                double d2 = getDistance(o2, origin);
                if (d1 == d2) {
                    return 0;
                }else if (d1 <d2) {
                    return  -1;
                }else {
                    return 1;
                }
            }
        }

        Queue<Point> queue = new PriorityQueue<>();
        for (Point p : points) {
            
        }

        return null;


    }

    private double getDistance(Point a, Point b) {
        return (double)Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) *(a.y - b.y));
    }


    public class pointComparator implements Comparator<Point>{

        @Override
        public int compare(Point o1, Point o2) {
            return 0;
        }
    }

    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return 0;

    }

    public int[] topk(int[] nums, int k) {
        // Write your code here
        int[] result = new int[k];
        Queue<Integer> minHeap = new PriorityQueue<>(k, new numComparator());

        for (int i : nums) {
            if (minHeap.size() < k) {
                minHeap.add(i);
                continue;
            }

            int min = minHeap.peek();
            if (min < i) {
                minHeap.poll();
                minHeap.add(i);
            }
        }

        int i = minHeap.size() - 1;
        while(!minHeap.isEmpty()) {
            result[i--] = minHeap.poll();
        }
        return result;
    }


    public class numComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 == o2) {
                return 0;
            }
            return o1 - o2;
        }
    }
    public static void main(String[] args) {
        System.out.println("Test");

        Aug09 a = new Aug09();
        a.topk(new int[]{
                1, 3, 2, 45,12
        }, 10);
    }


}
