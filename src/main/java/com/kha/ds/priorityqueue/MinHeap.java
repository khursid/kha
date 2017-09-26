package main.java.com.kha.ds.priorityqueue;

/**
 * Created by Mohammad.Ansari1 on 25-09-2017.
 */
public class MinHeap {

    public Integer[] insert(Integer[] heap, int lastIndex, Integer object){
        heap[lastIndex] = object;
        heapifyFromLast(heap, lastIndex);
        return heap;
    }

    public Integer removeTop(Integer[] heap, int lastIndex){
        Integer top = heap[0];
        heap[0] = heap[lastIndex-1];
        heap[lastIndex-1]=null;
        heapifyFromFirst(heap, lastIndex);
        return top;
    }

    /*public Integer[] getHeap(){
        return heap;
    }*/

    private void swap(Integer[] heap, int n1, int n2){
        Integer temp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = temp;
    }

    private void heapifyFromLast(Integer[] heap, int lastIndex){
        int index = lastIndex-1;
        int pIndex = index/2;
        while(index>0){
            if(heap[pIndex]>heap[index]){
                swap(heap, pIndex, index);
                index = pIndex;
                pIndex = pIndex/2;
            }else {
                break;
            }

        }
    }

    private void heapifyFromFirst(Integer[] heap, int lastIndex){
        int index = lastIndex-1;
        int pIndex = 0;
        int lIndex = 0;
        int rIndex = 0;
        while(lIndex < index || rIndex <index ){
            lIndex=pIndex*2+1;
            rIndex=pIndex*2+2;
            if(lIndex < index && rIndex <index && (heap[pIndex]==null || (heap[lIndex] < heap[pIndex] && heap[lIndex] < heap[rIndex]))){
                swap(heap, lIndex, pIndex);
                pIndex=lIndex;
            }else if(lIndex < index && rIndex <index && (heap[pIndex]==null || (heap[rIndex] < heap[pIndex] && heap[rIndex] < heap[lIndex]) )){
                swap(heap, rIndex, pIndex);
                pIndex=rIndex;
            }else if(lIndex < index && ( heap[pIndex]==null || heap[lIndex] < heap[pIndex])){
                swap(heap, lIndex, pIndex);
                pIndex=lIndex;

            }else if (rIndex <index && ( heap[pIndex]==null || heap[rIndex] < heap[pIndex])){
                swap(heap, rIndex, pIndex);
                pIndex=rIndex;
            }else {
                break;
            }
        }

    }

    public static void main(String[] args) {
        String str = "1 3 9 20 20 25 29 30 33 56 65 69 83 2 6 14 23 26 28 30 37 47 58 68 72 84 2 7 18 24 30 31 36 37 52 65 71 76 90 3 12 22 25 30 37 38 50 57 66 74 85 92 4 13 22 27 33 42 44 51 57 66 75 85 94 4 15 24 29 35 42 45 52 60 68 80 87 94 6 15 25 29 38 43 47 53 63 69 81 88 96 8 16 25 30 40 46 55 59 68 70 81 88 97 9 18 27 32 40 51 57 61 69 74 82 89 97 10 19 28 33 41 52 63 68 71 77 83 89 98 12 20 28 35 41 57 65 71 76 79 85 92 98 14 20 30 44 46 66 68 72 77 82 87 96 99 16 22 35 54 57 68 71 79 87 93 95 98 100";
        String[] st = str.split(" ");
        MinHeap maxHeap = new MinHeap();
        Integer[] heap = new Integer[200];
        Integer lastIndex = 0;
        for(String s : st){
            maxHeap.insert(heap, lastIndex, new Integer(s));
            lastIndex++;
        }
        for(int i= 0;i<st.length;i++){
            Integer top = maxHeap.removeTop(heap, lastIndex);
            lastIndex--;
            System.out.println( i + " : " + top + " ");
        }
    }
}

