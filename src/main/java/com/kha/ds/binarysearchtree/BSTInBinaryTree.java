package main.java.com.kha.ds.binarysearchtree;

/**
 * Created by Mohammad.Ansari1 on 30-09-2017.
 */
public class BSTInBinaryTree {
    class Meta{
        boolean isBST=true;
        int size=0;
        int min=Integer.MIN_VALUE;
        int max =Integer.MAX_VALUE;
    }
    int ans=0;
    public int largestBst(Node tree) {
        BST(tree);
        System.out.println(ans);
        return ans;
    }
    public Meta BST(Node node) {
        Meta meta = new Meta();
        if(node==null){
            return meta;
        }
        Meta left = BST(node.left);
        Meta right = BST(node.right);
        meta.isBST = left.isBST && right.isBST;

        meta.size = left.size+right.size+1;
        if(node.data >left.min && node.data <right.max && meta.isBST){
            ans = Math.max(ans, meta.size);
        }else {
            meta.isBST=false;
        }

        meta.min = Math.max(node.data, left.min);
        meta.max = Math.min(node.data, right.max);
        return meta;
    }

    public static void main(String[] args) {
        Node node = new  Node();
        node.data =1;

        Node node1 = new  Node();
        node1.data =3;
        Node node2 = new  Node();
        node2.data =2;

        node.left = node1;
        node.right=node2;
        new BSTInBinaryTree().largestBst(node);






    }


}
