public class Aug24 {
    public static void main(String[] args) {

    }



}

class inorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }

        // Find Where P is
        TreeNode thePreviousLastLargerThanRoot = null;
        while (root != p && root != null) {
            if (root.val < p.val) {
                root = root.right;
            }else {
                thePreviousLastLargerThanRoot = root;
                root = root.left;
            }
        }


        if (root == null) {
            return null;
        }



        if (root.right == null) {
            // If right doesn't exists also return null
            return thePreviousLastLargerThanRoot;
        }

        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}




