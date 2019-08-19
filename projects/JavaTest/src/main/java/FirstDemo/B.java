package FirstDemo;

/**
 * JavaTest<br> Created by yangxiaohua on 2019/3/15.
 */
public class B extends A {
  private String s = "this is B";
  private int s4 = 4;

  @Override
  public String say() {
    return s;
  }

  public void saySomeThings() {
    System.out.println(s4);
  }

  @Override
  protected B build() {
    B b = (B) super.build();
    return b;
  }

}
