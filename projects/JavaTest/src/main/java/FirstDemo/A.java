package FirstDemo;

/**
 * JavaTest<br> Created by yangxiaohua on 2019/3/15.
 */
public class A {
  private String s = "this is A";
  private int s1;
  private int s2;

  public int getS1() {
    return s1;
  }

  public void setS1(int s1) {
    this.s1 = s1;
  }

  public int getS2() {
    return s2;
  }

  public void setS2(int s2) {
    this.s2 = s2;
  }

  public int getS3() {
    return s3;
  }

  public void setS3(int s3) {
    this.s3 = s3;
  }

  private int s3;

  public String say() {
    return s;
  }

  protected A build() {
    setS1(1);
    setS2(2);
    setS3(3);
    return this;
  }
}
