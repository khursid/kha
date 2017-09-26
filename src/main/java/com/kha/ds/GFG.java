package main.java.com.kha.ds;

/**
 * Created by Mohammad.Ansari1 on 25-09-2017.
 */
public class GFG {

    public static void swap(int[] arr1, int[] arr2, int[] arr3, int a, int b){
        int temp = arr1[a];
        arr1[a] = arr1[b];
        arr1[b]=temp;

        temp = arr2[a];
        arr2[a] = arr2[b];
        arr2[b]=temp;

        temp = arr3[a];
        arr3[a] = arr3[b];
        arr3[b]=temp;

    }

    public static void heapify(int[] a, int []b, int []c){
        int n = a.length;
        int pIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while(pIndex < n){
            leftIndex = 2*pIndex+1;
            rightIndex = 2*pIndex+2;

            if(leftIndex < n && rightIndex <n ){
                if(a[pIndex] > a[leftIndex] && a[leftIndex] < a[rightIndex]){
                    swap(a, b, c, pIndex, leftIndex);
                    pIndex = leftIndex;
                }else if (a[pIndex] > a[rightIndex] && a[rightIndex] < a[leftIndex]){
                    swap(a, b, c, pIndex, rightIndex);
                    pIndex = rightIndex;
                }else {
                    break;
                }

            }else if(leftIndex < n){
                if(a[pIndex] > a[leftIndex]){
                    swap(a, b, c, pIndex, leftIndex);
                    pIndex = leftIndex;
                }else {
                    break;
                }

            }else if(rightIndex < n){
                if(a[pIndex] > a[rightIndex]){
                    swap(a, b, c, pIndex, rightIndex);
                    pIndex = rightIndex;
                }else {
                    break;
                }
            }else {
                System.out.print(" ");
                break;
            }
        }
        System.out.print(" ");
    }


    public static void kthSmallest(int[][] a,int n,int k){
        int[] heap = new int[n];
        int[] col = new int[n];
        int[] row = new int[n];
        for(int i=0;i<n;i++){
            heap[i] = a[0][i];
            col[i] = i;
            row[i] = 0;
        }


        for(int i=0;i<k-1;i++){
            row[0] = row[0] + 1;
            //System.out.print(heap[0]);
            if(row[0]<n){
                heap[0] =  a[row[0]][col[0]];
            }else{
                heap[0] = Integer.MAX_VALUE;
            }
            heapify(heap, col, row);
            System.out.print("");
        }
        System.out.print(heap[0]);

    }

    public static void main(String[] args) {
        int n=4;
        int[] input = new int[]{16,28,60,64,22,41,63,91,27,50,87,93,36,78,87,94};
        int[][] arr = new int[n][n];
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=input[index++];
            }
        }
        kthSmallest(arr, n, 3);
    }
}
