package main.java.com.kha.designpattern;

/**
 * Created by Mohammad.Ansari1 on 27-09-2017.
 */
public class EnumSingletonTester {
    static class NodeInsideClass{
        NodeInsideClass(){
            System.out.print("NodeInsideClass Constructor called");
        }
    }



    public static void main(String[] args) {
        NodeInsideClass nic = new NodeInsideClass();

        EnumSingleton.INSTANCE.doSomething();
    }
}
