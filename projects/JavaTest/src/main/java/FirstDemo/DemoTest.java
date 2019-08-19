package FirstDemo;

public class DemoTest {
  public static void main(String[] args) {
    System.out.println("1111");

    A a = new B();
    B b = (B) a;
    A a2 = (A) b;
    System.out.println(b.say());
    System.out.println( a2.say());
    b.saySomeThings();
    b.build();
  }
}
