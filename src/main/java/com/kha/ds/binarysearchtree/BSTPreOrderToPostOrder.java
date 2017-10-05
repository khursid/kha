package main.java.com.kha.ds.binarysearchtree;

import java.util.Scanner;

/**
 * Created by Mohammad.Ansari1 on 27-09-2017.
 */
public class BSTPreOrderToPostOrder {

    static int[] arr;

    public static void printPostOrder(int[] arr1, int n){
        arr=arr1;
        if(validPreOrder(0, n-1)){
            printPostOrder(0, n-1);
        }else {
            System.out.print("NO");
        }
        System.out.println();
    }

    public static boolean validPreOrder(int x, int y){
        if(y<x){
            return true;
        }
        if(y==x){
            return true;
        }
        if(y==x+1){
            return true;
        }
        int rightIndex=0;
        boolean rightIndexFound = false;
        for(int i=x+1;i<=y;i++){
            if(arr[x] < arr[i] && !rightIndexFound){
                rightIndexFound = true;
                rightIndex=i;
            }else if(arr[x] > arr[i] && rightIndexFound){
                return false;
            }
        }
        boolean preOrderExistLeft = printPostOrder(x+1, rightIndex-1);
        boolean preOrderExistRight =printPostOrder(rightIndex, y);
        return preOrderExistLeft & preOrderExistRight;
    }

    public static boolean printPostOrder(int x, int y){
        if(y<x){
            return true;
        }
        if(y==x){
            System.out.print(arr[x]+" ");
            return true;
        }
        if(y==x+1){
            System.out.print(arr[y]+" ");
            System.out.print(arr[x]+" ");
           return true;
        }
        int rightIndex=0;
        boolean rightIndexFound = false;
        for(int i=x+1;i<=y;i++){
            if(arr[x] < arr[i] && !rightIndexFound){
                rightIndexFound = true;
                rightIndex=i;
            }else if(arr[x] > arr[i] && rightIndexFound){
                return false;
            }
        }

        if(rightIndexFound && x+1==rightIndex){
            printPostOrder(rightIndex, y);
        }else if (rightIndexFound){

        }


        boolean preOrderExistRight =printPostOrder(rightIndex, y);
        System.out.print(arr[x]+" ");
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i=0;i<testCase;i++){
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for(int j=0;j<len;j++){
                arr[j]=scanner.nextInt();
            }
            printPostOrder(arr, len);
        }

    }


}
