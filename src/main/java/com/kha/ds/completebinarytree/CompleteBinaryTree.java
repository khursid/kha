package main.java.com.kha.ds.completebinarytree;

import main.java.com.kha.ds.TreeNode;

/**
 * Created by Mohammad.Ansari1 on 19-09-2017.
 */
public class CompleteBinaryTree {
    public TreeNode rootNode;
    public Integer currentSize = 0;


    public void insert(TreeNode data){
        rootNode = insert(rootNode, data, currentSize);
    }
    /* Function to insert data recursively */
    private TreeNode insert(TreeNode node, TreeNode data, Integer size){
        if (node == null){
            node = data;
            currentSize = currentSize +1;
        } else{
            NextMove nextMove = moveRight(size);
            if (nextMove.right){
                node.right = insert(node.right, data, nextMove.size);
            }else{
                node.left = insert(node.left, data, nextMove.size);
            }
        }
        return node;
    }

    private NextMove moveRight(Integer rootNodeSize){
        int levelCompleted = (int)(Math.log(rootNodeSize + 1)/Math.log(2) -1);
        int currentHalf =  (int)Math.pow(2, levelCompleted);
        int maxPossibleNumber = (int)Math.pow(2, levelCompleted+2)-1;
        int currentPosition = maxPossibleNumber-rootNodeSize;

        NextMove nextMove = new NextMove();
        if(currentPosition <= currentHalf){
            nextMove.right=true;
            nextMove.size= (maxPossibleNumber - 1)/2;
        }else {
            nextMove.right=false;
            nextMove.size=(maxPossibleNumber - 1)/2 -currentHalf;
        }
        return nextMove;
    }



    private void get(){

    }
}
