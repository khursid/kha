package main.java.com.kha.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Mohammad.Ansari1 on 11-08-2017.
 */
public class FutureExample {
    public static void main(String[] args){
        List<Future<String>> futures= new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i=0;i<10;i++){
            Callable<String> callable = new MyCallable();
            Future<String> future = executor.submit(callable);
            futures.add(future);
        }
        for(Future<String> result : futures){
            try {
                String str = result.get();
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
