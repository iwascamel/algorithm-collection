import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main{
    static class A{
        void print(){
            System.out.println("A");
        }
    }
    static class B extends A{
        void print(){
            System.out.println("B");
        }
    }
    public static void main(String[] args) {
        A a = new A();
        A b = new B();

        a.print();
        b.print();
    }
}
