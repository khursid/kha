package main.java.com.kha.ds.priorityqueue;

/**
 * Created by Mohammad.Ansari1 on 26-09-2017.
 */
public class Stack {
    char[] stack;
    int size;

    public static void init(int n){
        char[] stack = new char[n];
        int size = 0;
    }
    public void push(char ch){
        stack[size++]=ch;
    }
    public char pop(){
        return stack[--size];
    }
    public int getSize(){
        return size;
    }
    public void print(){
        System.out.print(" [");
        for(int i=0;i<size;i++){
            System.out.print(stack[i]);
        }
        System.out.print("] ");
    }
}
