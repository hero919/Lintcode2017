import java.util.*;

/**
 * Created by tzhang on 7/22/2017.
 */
public class Jul22 {
    public static void main(String[] args) {
        System.out.println("Test");
    }
}


class Search_Graph_Nodes{
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        // Write your code here
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();

        queue.offer(node);
        hash.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (values.get(head) == target) {
                return head;
            }
            for (UndirectedGraphNode nei : head.neighbors) {
                if (!hash.contains(nei)){
                    queue.offer(nei);
                    hash.add(nei);
                }
            }
        }
        return null;

    }
}




// Definition for graph node.
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x)
    {
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }
 };