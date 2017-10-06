package main.java.com.kha.ds.linkedlist;

import java.util.Scanner;

/**
 * Created by Mohammad.Ansari1 on 06-10-2017.
 */
public class FlattenLinkedListSolution {
    public Node flatten(Node root){
        if(root==null){
            return null;
        }
        Node result = new Node(Integer.MIN_VALUE);
        result.bottom = root;
        while (root.next!=null){
            Node column = root.next;
            while (column!=null){
                insert(result, column.data);
                column = column.bottom;
            }
            root = root.next;
        }
        Node ans = result.bottom;
        while (ans!=null){
            System.out.print(ans.data + " ");
            ans = ans.bottom;
        }
        return result.bottom;
    }




    public void insert(Node node, int value){
        Node prevPtr = node; //Assuming head is never null and contains least value
        Node ptr = prevPtr.bottom;
        while(ptr!=null){
            if(ptr.data<value){
                prevPtr = prevPtr.bottom;
                ptr = ptr.bottom;
            }else {
               prevPtr.bottom = new Node(value);
               prevPtr.bottom.bottom = ptr;
               return;
            }
        }
        prevPtr.bottom = new Node(value);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int i=0;i<testCases;i++){
            int headLength = scanner.nextInt();
            int[] elementInEachHeadArr = new int[headLength];
            for(int j=0;j<headLength;j++){
                elementInEachHeadArr[j] = scanner.nextInt();
            }
            Node rootNode = null;
            Node next = null;
            Node down = null;

            for(int j=0;j<elementInEachHeadArr.length;j++){
                int elementInHead = elementInEachHeadArr[j];
                for(int k=0;k<elementInHead;k++){
                    int data = scanner.nextInt();
                    Node node = new Node(data);
                    if(j==0 && k==0){
                        rootNode = node;
                        next = node;
                        down = node;
                    }else if(k==0){
                        next.next = node;
                        next = node;
                        down = node;
                    }else {
                        down.bottom=node;
                        down = node;
                    }
                }
            }
            new FlattenLinkedListSolution().flatten(rootNode);

        }
    }
}
