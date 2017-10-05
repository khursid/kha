package main.java.com.kha.ds.binarysearchtree;

import java.util.Scanner;

/**
 * Created by Mohammad.Ansari1 on 28-09-2017.
 */
public class PreToPostBSTTree {
    class Node{
        int key;
        Node left,right;
        public Node(int item){
            key = item;
            left = null;
            right = null;
        }
    }

    Node root;

    PreToPostBSTTree(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root,key);
    }

    Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(root.key > key){
            root.left = insertRec(root.left,key);
        }
        else if(root.key < key)
            root.right = insertRec(root.right,key);
        return root;
    }

    String s = "";

    void preOrder(Node root){
        if(root != null){
            s += (root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void preOrderRec(){
        preOrder(root);
    }

    void postOrderRec(){
        postOrder(root);
    }

    void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+" ");
        }
    }

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            PreToPostBSTTree tree = new PreToPostBSTTree();
            int n = sc.nextInt();
            int[] a = new int[n];
            String l = "";
            for (int i = 0; i < a.length; i++) {
                int x = sc.nextInt();
                tree.insert(x);
                l += (x + " ");
            }
            tree.preOrderRec();
            String k = tree.s;
            //System.out.print(k+" ");
            if (k.equals(l)) {
                tree.postOrderRec();
                System.out.println();
            } else {
                System.out.println("NO");
            }
        }
    }
}
