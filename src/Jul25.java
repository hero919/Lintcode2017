import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tzhang on 7/25/2017.
 */
public class Jul25 {

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        for (int n : nums) {
            if (n == 0) {
                j++;
                continue;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }

        for (int index = i; index < nums.length; index++) {
            nums[index] = 0;
        }

        for (int number : nums){
            System.out.print(number + " ");
        }
    }

    // Binary Tree Serialization

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */

    private final String splitter = ",";
    private final String NN = "X";
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        buildTree(sb, root);
        return sb.toString();
    }


    private void buildTree(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(NN).append(splitter);
            return;
        }
        sb.append(root.val).append(splitter);
        buildTree(sb, root.left);
        buildTree(sb, root.right);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return deserializeHelper(queue);
    }


    TreeNode deserializeHelper(Queue<String> queue) {
        String top = queue.poll();
        if (top.equals(NN)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(top));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }






    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n2.right = n4;
        n3.left = n5;

        Jul25 j = new Jul25();
        //System.out.println(j.serialize(n1));

        System.out.println("Hello,ThisisaTest,a".split(",").length);

    }


}
