import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul26 {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }

        String main = data.substring(1, data.length() - 1);
        String[] component = main.split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(component[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 0; i < component.length; i++) {
            if (!component[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(component[i]));
                if(isLeftChild) {
                    queue.get(index).left = node;
                }else{
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;


    }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            // write your code here
            List<List<Integer>> result = new ArrayList<>();
            if (candidates == null || candidates.length == 0) {
                return new ArrayList<>();
            }

            Arrays.sort(candidates);
            combinationHelper(candidates, result, new ArrayList<>(), target, 0);
            return result;
        }

        private void combinationHelper(int[] candidates, List<List<Integer>> result, List<Integer> subset, int rest, int index) {
            if (rest == 0 && !result.contains(subset)) {
                result.add(new ArrayList<>(subset));
                return;
            }

            if(rest < 0) {
                return;
            }

            for(int i = index; i < candidates.length; i++) {
                subset.add(candidates[i]);
                combinationHelper(candidates, result, subset, rest - candidates[i], i);
                subset.remove(subset.size() - 1);
            }
        }







    public static void main(String[] args) {
        System.out.println("Test");
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n2.right = n4;
        n3.left = n5;
        Jul26 j = new Jul26();
        //System.out.println(j.serialize(n1));
        System.out.println(j.combinationSum(new int[]{
                2,2,3
        }, 7));
    }
}
