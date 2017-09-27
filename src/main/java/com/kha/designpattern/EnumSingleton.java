package main.java.com.kha.designpattern;

/**
 * Created by Mohammad.Ansari1 on 27-09-2017.
 */
public enum EnumSingleton {
    INSTANCE;

    EnumSingleton(){
        System.out.print("EnumSingleton Constructor called");
    }

    public void doSomething(){
        System.out.print("EnumSingleton doSomething called");
    }
}
