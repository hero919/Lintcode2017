import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Aug03 {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root, result);
        return result;
    }

    private void preorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelper(root.left, result);
        preorderTraversalHelper(root.right, result);
    }

    public ArrayList<Integer> preorderTraversal02(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return result;
    }


    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }





    public static void main(String[] args) {
        System.out.println("Test");
    }
}
