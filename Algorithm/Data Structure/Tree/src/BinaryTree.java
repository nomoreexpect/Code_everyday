/**
 * @Author:PanYa
 * @Date 2024/5/11-上午10:47
 * @Description:
 */
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//public class BinaryTree {
//
//    // 前序遍历
//    public void preorderTraversal(TreeNode root) {
//        /*
//        *@Param [root]
//        *@return void
//        *@Description:递归实现
//        */
//        if (root != null) {
//            System.out.print(root.val + " ");
//            preorderTraversal(root.left);
//            preorderTraversal(root.right);
//        }
//    }
//
//    // 中序遍历
//    public void inorderTraversal(TreeNode root) {
//        if (root != null) {
//            inorderTraversal(root.left);
//            System.out.print(root.val + " ");
//            inorderTraversal(root.right);
//        }
//    }
//
//    // 后序遍历
//    public void postorderTraversal(TreeNode root) {
//        if (root != null) {
//            postorderTraversal(root.left);
//            postorderTraversal(root.right);
//            System.out.print(root.val + " ");
//        }
//    }



public class BinaryTree {
    // 前序遍历
    public void preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    // 中序遍历
    public void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    // 后序遍历
    public void postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || root.right == prev) {
                System.out.print(root.val + " ");
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
    }


    public static void main(String[] args) {
        // 创建一个简单的二叉树
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTree tree = new BinaryTree();

        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(root);
        System.out.println();

        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorderTraversal(root);
        System.out.println();
    }
}

