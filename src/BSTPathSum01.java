import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BSTPathSum01 {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subArray = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, target,result, subArray);

        return result;
    }

    private void helper(TreeNode root, int left, List<List<Integer>> result, List<Integer> subArray) {
        if (root == null) {
            return;
        }
        if (left - root.val == 0 && root.left == null && root.right == null) {
            subArray.add(root.val);
            result.add(new ArrayList<>(subArray));
            return;
        }


        subArray.add(root.val);
        helper(root.left, left - root.val, result, new ArrayList<>(subArray));
        helper(root.right, left - root.val, result, new ArrayList<>(subArray));
    }


//    public static void main(String[] args) {
//        TreeNode t0 = new TreeNode(1);
//        TreeNode t1 = new TreeNode(2);
//        TreeNode t2 = new TreeNode(2);
//        t0.left = t1;
//        t0.right = t2;
//        BSTPathSum01 b = new BSTPathSum01();
//        System.out.println(b.binaryTreePathSum(t0, 3));
//    }
}


class BSTPathSum02 {
    public List<List<Integer>> binaryTreePathSum02(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subArray = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, target,result, subArray);

        return result;
    }

    private void helper(TreeNode root, int total, List<List<Integer>> result, List<Integer> subArray) {
        if (root == null) {
            return;
        }

        subArray.add(root.val);

        int sum = 0;
        for (int i = subArray.size() - 1; i >= 0; i--) {
            sum += subArray.get(i);
            if (sum == total) {
                List<Integer> ans = new ArrayList<>();
                for (int j = i; j < subArray.size(); j++) {
                    ans.add(subArray.get(j));
                }
                result.add(ans);
            }
        }




        helper(root.left, total, result, new ArrayList<>(subArray));
        helper(root.right, total, result, new ArrayList<>(subArray));
    }

    public static void main(String[] args) {
        BSTPathSum02 b = new BSTPathSum02();
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);

        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t2.left = t4;

        System.out.println(b.binaryTreePathSum02(t0, 6));
    }
}


class BSTPathSum03 {
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        return new ArrayList<>();
    }




}
class ParentTreeNode {
      public int val;
      public ParentTreeNode parent, left, right;
}

class Binary_Tree_Maximum_Path_Sum {
    class ResultType {
        int singlePath;
        int totalSum;
        ResultType(int singlePath, int totalSum) {
            this.singlePath = singlePath;
            this.totalSum = totalSum;
        }
    }
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);
        return maxSum;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int singlePath = Math.max(Math.max(left.singlePath + root.val, right.singlePath + root.val), root.val);
        int sum = left.singlePath + right.singlePath + root.val;
        maxSum = Math.max(Math.max(sum, singlePath), maxSum);
        return new ResultType(singlePath, sum);
    }




}