package main.java.com.kha.ds.binarysearchtree;

import java.util.Scanner;

/**
 * Created by Mohammad.Ansari1 on 27-09-2017.
 */
public class BSTPreOrderToPostOrder {

    static int  resSize = 0;
    static int[] res;
    static int[] arr;

    public static void printPostOrder(int[] arr1, int n){
        resSize=0;
        res = new int[n];
        arr=arr1;
        boolean found = printPostOrder(0, n-1);
        if(found){
            for(int i : res){
                System.out.print(i+" ");
            }
        }else {
            System.out.print("NO");
        }
        System.out.println();

    }

    public static boolean printPostOrder(int x, int y){
        if(y<x){
            return true;
        }
        if(y==x){
            res[resSize++] = arr[x];
            return true;
        }
        if(y==x+1){
            res[resSize++] = arr[y];
            res[resSize++] = arr[x];
           return true;
        }
        int root = arr[x];
        int rightIndex=0;
        boolean rightIndexFound = false;
        for(int i=x+1;i<=y;i++){
            if(root < arr[i] && !rightIndexFound){
                rightIndexFound = true;
                rightIndex=i;
            }else if(root > arr[i] && rightIndexFound){
                return false;
            }
        }

        boolean preOrderExistLeft = printPostOrder(x+1, rightIndex-1);

        boolean preOrderExistRight =printPostOrder(rightIndex, y);
        res[resSize++] = root;
        return preOrderExistLeft & preOrderExistRight;
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
