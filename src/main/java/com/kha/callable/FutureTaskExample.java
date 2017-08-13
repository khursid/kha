package main.java.com.kha.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Mohammad.Ansari1 on 11-08-2017.
 */
public class FutureTaskExample {
    public static void main(String[] args){
        List<FutureTask<String>> futureTaskList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
            executor.execute(futureTask);
            futureTaskList.add(futureTask);
        }
        try {
            for(FutureTask<String> futureTask : futureTaskList){
                String str = futureTask.get();
                System.out.println(str);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
