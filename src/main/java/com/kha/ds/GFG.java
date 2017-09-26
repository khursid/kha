package main.java.com.kha.ds;

/**
 * Created by Mohammad.Ansari1 on 25-09-2017.
 */
public class GFG {



    private static void swap(int[] heap, int n1, int n2){
        int temp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = temp;
    }


    public static void kthSmallest(int[][] a,int n,int k){
        int[] heap = new int[n];
        int[] row = new int[n];
        int[] col = new int[n];

        for(int i=0;i<n;i++){
            heap[i] = a[0][i];
            col[i]=i;
        }

        for(int i=0;i<k;i++){
            System.out.println(i +" : "+ heap[0]);
            if(i==k-1){
                System.out.println(heap[0]);
            }
            int nextCol = col[0];
            if(row[0] < n-1){
                int nextRow = ++row[0];
                heap[0] = a[nextRow][nextCol];
            }else {
                heap[0] = 200;
            }
            int pIndex = 0;
            int lIndex = 2 *pIndex+1;
            int rIndex = 2 *pIndex+2;

            while( lIndex < n || rIndex < n){
                if(lIndex < n && rIndex < n && heap[lIndex]<heap[pIndex] && heap[lIndex] < heap[rIndex]){
                    swap(heap, lIndex, pIndex);
                    swap(row , lIndex, pIndex);
                    swap(col, lIndex,pIndex);
                    pIndex = lIndex;
                }else if(lIndex < n && rIndex < n && heap[rIndex]<heap[pIndex] && heap[rIndex] < heap[lIndex]){
                    swap(heap, rIndex, pIndex);
                    swap(row , rIndex, pIndex);
                    swap(col, rIndex,pIndex);
                    pIndex = rIndex;
                }else if(lIndex < n && heap[lIndex]<heap[pIndex]){
                    swap(heap, lIndex, pIndex);
                    swap(row , lIndex, pIndex);
                    swap(col, lIndex,pIndex);
                    pIndex = lIndex;
                }else if(rIndex < n && heap[rIndex]<heap[pIndex]){
                    swap(heap, rIndex, pIndex);
                    swap(row , rIndex, pIndex);
                    swap(col, rIndex,pIndex);
                    pIndex = rIndex;
                }else {
                    break;
                }
                 lIndex = 2 *pIndex+1;
                 rIndex = 2 *pIndex+2;
            }

        }
    }



    public static void main(String[] args) {
        int n=4;
        //String str = "1 3 9 20 20 25 29 30 33 56 65 69 83 2 6 14 23 26 28 30 37 47 58 68 72 84 2 7 18 24 30 31 36 37 52 65 71 76 90 3 12 22 25 30 37 38 50 57 66 74 85 92 4 13 22 27 33 42 44 51 57 66 75 85 94 4 15 24 29 35 42 45 52 60 68 80 87 94 6 15 25 29 38 43 47 53 63 69 81 88 96 8 16 25 30 40 46 55 59 68 70 81 88 97 9 18 27 32 40 51 57 61 69 74 82 89 97 10 19 28 33 41 52 63 68 71 77 83 89 98 12 20 28 35 41 57 65 71 76 79 85 92 98 14 20 30 44 46 66 68 72 77 82 87 96 99 16 22 35 54 57 68 71 79 87 93 95 98 100 ";
        //String[] st = str.split(" ");
        int[] input = new int[]{16,28,60,64,22,41,63,91,27,50,87,93,36,78,87,94};
        int[][] arr = new int[n][n];
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=input[index++];
            }
        }
        kthSmallest(arr, n, 16);
    }
}
