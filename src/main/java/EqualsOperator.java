public class EqualsOperator {
  public static void main(String[] args) {

    // ==比较两个变量本身的值 即两个对象在内存中的地址
    // equals 比较字符串中所包含的内容是否相同
    String s1 = "abc";
    String s2 = new String("abc");
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
