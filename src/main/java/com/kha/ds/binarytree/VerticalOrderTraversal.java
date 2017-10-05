package main.java.com.kha.ds.binarytree;

import main.java.com.kha.ds.binarysearchtree.Node;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Mohammad.Ansari1 on 04-10-2017.
 */
public class VerticalOrderTraversal {


    int lengthTree(Node node){
        Thread.currentThread().getId();
        Lock lock = new ReentrantLock();
        lock.lock();
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right == null){
            return 1;
        }
        return 1+lengthTree(node.left)+lengthTree(node.right);
    }

    Queue[] list = null;
    int x = 0;
    void verticalOrderTraversal(Node node, int pHD) {
        if(node == null){
            return;
        }
        Queue queue = list[pHD+x];
        if(queue==null){
            Queue queue1 = new ArrayDeque();
            queue1.add(node);
            list[pHD+x]=queue1;
        }else {
            queue.add(node);
        }
        verticalOrderTraversal(node.left,  pHD-1);
        verticalOrderTraversal(node.right,  pHD+1);
    }

    void verticalOrder(Node node) {
        int n = lengthTree(node);
        list = new Queue[2 * n-1];
        x = n-1;
        verticalOrderTraversal(node, 0);
        for(int i=0;i<list.length;i++){
            Queue queue = list[i];
            if(queue !=null){
                while (!queue.isEmpty()){
                    System.out.print(((Node)queue.poll()).data);
                }
                System.out.print("$");
            }
        }


    }


}
