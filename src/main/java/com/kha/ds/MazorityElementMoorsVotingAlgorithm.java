package main.java.com.kha.ds;

import java.util.Scanner;

/**
 * Created by Mohammad.Ansari1 on 05-10-2017.
 */
public class MazorityElementMoorsVotingAlgorithm {

    public static int findCandidate(int[] arr){
        int index = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                index = i;
            }
            if(arr[index] == arr[i]){
                count++;
            }else {
                count--;
            }

        }
        return arr[index];
    }

    public static void printMazorityElement(int[] arr){
        int candidate = findCandidate(arr);
        int counter = 0;
        for(int i=0;i<arr.length;i++){
            if(candidate == arr[i]){
                counter++;
            }
            if(counter>arr.length/2){
                System.out.println(candidate);
                return;
            }
        }
        System.out.println("NO Majority Element");
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i =0;i<testCase;i++){
            int n = scanner.nextInt();
            int arr[] = new int[n];
            for(int j=0;j<n;j++){
                arr[j] = scanner.nextInt();
            }
            printMazorityElement(arr);
        }
    }


}
