object Generic {
  def main(args: Array[String]): Unit = {

    // 普通多态 子类实例赋给父类引用
    val c1: High = new Mid

    // 协变 Child是Parent子类 MyCollection1[Child]也是MyCollection1[Parent]子类
    val collection1: MyCollection1[High] = new MyCollection1[Mid]

    // 逆变 Child是SubChild父类 MyCollection2[Child]反而成为了MyCollection2[SubChild]的子类
    val collection2: MyCollection2[Low] = new MyCollection2[Mid]



    // 泛型通配符之上限
    def f1[A <: Mid](a: A): Unit = {
      println(a.getClass.getName)
    }
    f1(new Low)

    // 泛型通配符之下限
    def f2[A >: Mid](a: A): Unit = {
      println(a.getClass.getName)
    }
    f2(new High)

  }
}

class High
class Mid extends High
class Low extends Mid
class MyCollection1[+G]
class MyCollection2[-G]
