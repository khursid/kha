package main.java.com.kha.ds;

/**
 * Created by Mohammad.Ansari1 on 19-09-2017.
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public Object value;

    public TreeNode(Object object){
        this.value=object;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
