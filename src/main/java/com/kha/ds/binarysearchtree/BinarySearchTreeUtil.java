package main.java.com.kha.ds.binarysearchtree;

import java.util.Stack;

/**
 * Created by Mohammad.Ansari1 on 27-09-2017.
 */
public class BinarySearchTreeUtil {

    boolean canRepresentBST(int pre[], int n) {
        Stack<Integer> s = new Stack<Integer>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre[i] < root) {
                return false;
            }
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
            s.push(pre[i]);
        }
        return true;
    }

    boolean canRepresentBST2(int pre[], int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int root = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(root > pre[i]){
                return false;
            }
            if(stack.isEmpty()){
                stack.push(pre[i]);
            }else if(!stack.isEmpty() && pre[i] < stack.peek()){
                stack.push(pre[i]);
            }else {
               while (!stack.isEmpty() && stack.peek() < pre[i]){
                   root = stack.pop();
               }
            }
        }
        return true;
    }



    public static void main(String args[]) {
        BinarySearchTreeUtil bst = new BinarySearchTreeUtil();
        int[] pre1 = new int[]{40, 30, 20, 10, 5, 25, 35, 80, 100};
        int n = pre1.length;
        if (bst.canRepresentBST2(pre1, n) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        /*int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        int n1 = pre2.length;
        if (bst.canRepresentBST(pre2, n1) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }*/
    }
}
