import java.util.*;

/**
 * Created by tzhang on 7/23/2017.
 */
public class Jul23 {

}


class CourseSchedule02 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here

        int[] results = new int[numCourses];
        if (numCourses == 0) {
            return new int[0];
        }

        if (prerequisites == null || prerequisites.length == 0 ){
            for (int i = 0; i < numCourses; i++){
                results[i] = i;
            }
            return results;
        }
        // Map (Course, NumberOfRestrictions(Array))
        Map<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();


        // Set All the courses for mutual conflicts
        for (int[] prerequest : prerequisites){
            int course = prerequest[0];
            int requirement = prerequest[1];
            if(map.containsKey(course) && !map.get(course).contains(requirement)) {
                map.get(course).add(requirement);
            }else {
                ArrayList<Integer> pre = new ArrayList<>();
                pre.add(requirement);
                map.put(course, pre);
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.add(i);
                result.add(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer top = queue.poll();
            for (Integer course : map.keySet()) {
                if (map.get(course).contains(top)) {
                    map.get(course).remove(top);
                    if (map.get(course).size() == 0) {
                        queue.add(course);
                        result.add(course);
                    }
                }
            }
        }

        if(result.size() != numCourses) {
            return new int[0];
        }



        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }
        return results;
    }


    // Subset with duplicate
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }

        ArrayList<Integer> subArray = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, subArray, 0);
        return result;
    }

    private void helper(int[] nums, ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> subArray, int pos){
        result.add(new ArrayList<>(subArray));
        for(int i = pos; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i -1] && i != pos) {
                continue;
            }
            subArray.add(nums[i]);
            helper(nums, result, subArray, i + 1);
            subArray.remove(subArray.size() - 1);
        }
    }




    // Valid Tree
    // The number of edges should equals to the number of nodes - 1 && When construct a tree all the nodes should be connected
    public static boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }

        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        queue.offer(0);
        hash.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (hash.contains(neighbor)) {
                    continue;
                }
                hash.add(neighbor);
                queue.offer(neighbor);
            }
        }


        return (hash.size() == n);
    }

    private static Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }




    public static void main(String[] args) {

//      findOrder(10, new int[][]{
//              {5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}
//        });
        System.out.println(validTree(5, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}
        }));
    }
}

// 九章算法
//    // Write your code here
//    List[] edges = new ArrayList[numCourses];
//    int[] degree = new int[numCourses];
//
//        for (int i = 0;i < numCourses; i++)
//        edges[i] = new ArrayList<Integer>();
//
//        for (int i = 0; i < prerequisites.length; i++) {
//        degree[prerequisites[i][0]] ++ ;
//        edges[prerequisites[i][1]].add(prerequisites[i][0]);
//        }
//
//        Queue queue = new LinkedList();
//        for(int i = 0; i < degree.length; i++){
//        if (degree[i] == 0) {
//        queue.add(i);
//        }
//        }
//
//        int count = 0;
//        int[] order = new int[numCourses];
//        while(!queue.isEmpty()){
//        int course = (int)queue.poll();
//        order[count] = course;
//        count ++;
//        int n = edges[course].size();
//        for(int i = n - 1; i >= 0 ; i--){
//        int pointer = (int)edges[course].get(i);
//        degree[pointer]--;
//        if (degree[pointer] == 0) {
//        queue.add(pointer);
//        }
//        }
//        }
//
//        if (count == numCourses)
//        return order;
//
//        return new int[0];
