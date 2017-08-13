package main.java.com.kha.callable;

import java.util.concurrent.Callable;

/**
 * Created by Mohammad.Ansari1 on 11-08-2017.
 */
public class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        return Thread.currentThread().getName();
    }
}
