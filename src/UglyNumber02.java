import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumber02 {
    public static int nthUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            if (uglys.get(p2) * 2 <= lastNumber) p2++;
            if (uglys.get(p3) * 3 <= lastNumber) p3++;
            if (uglys.get(p5) * 5 <= lastNumber) p5++;

            uglys.add(Math.min(
                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                    uglys.get(p5) * 5
            ));
        }
        System.out.println(uglys);

        return uglys.get(n - 1);
    }




    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

}
