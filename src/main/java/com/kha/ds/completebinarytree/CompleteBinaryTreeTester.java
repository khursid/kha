package main.java.com.kha.ds.completebinarytree;

import main.java.com.kha.ds.TreeNode;

/**
 * Created by Mohammad.Ansari1 on 19-09-2017.
 */
public class CompleteBinaryTreeTester {
    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        tree.insert(new TreeNode(1));
        tree.insert(new TreeNode(2));
        tree.insert(new TreeNode(3));
        tree.insert(new TreeNode(5));
        tree.insert(new TreeNode(5));
        tree.insert(new TreeNode(6));
        tree.insert(new TreeNode(7));
        tree.insert(new TreeNode(8));

        tree.insert(new TreeNode(10));
        tree.insert(new TreeNode(9));



    }
}
