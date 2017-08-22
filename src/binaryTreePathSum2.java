import java.util.ArrayList;
import java.util.List;

public class binaryTreePathSum2 {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Algorithm: Traverse
        // Use recursion to traverse the tree in preorder, pass with a parameter
        // `sum` as the sum of each node from root to current node.
        // Put the whole path into result if the leaf has a sum equal to target.

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }

    private void helper(TreeNode root,
                        ArrayList<Integer> path,
                        int sum,
                        int target,
                        List<List<Integer>> result) {

        // meet leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        // go left
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            path.remove(path.size() - 1);
        }
        System.out.println(path);

        // go right
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;

        binaryTreePathSum2 b = new binaryTreePathSum2();
        System.out.println(b.binaryTreePathSum(t1, 6));
    }
}
