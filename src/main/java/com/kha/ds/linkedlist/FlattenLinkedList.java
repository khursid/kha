package main.java.com.kha.ds.linkedlist;

import java.util.Scanner;

/**
 * Created by Mohammad.Ansari1 on 05-10-2017.
 */
public class FlattenLinkedList {

    public Node flatten(Node root){
        if(root==null){
            return null;
        }
        while (root.next!=null){
            Node nextToNext = root.next.next;
            Node merged = merge(root, root.next);
            merged.next = nextToNext;
            root = merged;
        }
        while (root!=null){
            System.out.print(root.data + " ");
            root = root.bottom;
        }
        return root;
    }




    public Node merge(Node node1, Node node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        Node node = null;
        Node iterator = null;
        if(node1.data > node2.data){
            node = node2;
            iterator = node2;
            node2 = node2.bottom;
        }else {
            node = node1;
            iterator = node1;
            node1 = node1.bottom;
        }

        while (node1 != null || node2 != null){
            if(node1==null || (node1!=null && node2!=null && node1.data > node2.data)){
                iterator.bottom = node2;
                node2 = node2.bottom;
                iterator = iterator.bottom;
            }else if(node2==null || (node1!=null && node2!=null && node1.data < node2.data)){
                iterator.bottom = node1;
                node1 = node1.bottom;
                iterator = iterator.bottom;
            }
        }

        return node;
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
            new FlattenLinkedList().flatten(rootNode);

        }
    }
}
