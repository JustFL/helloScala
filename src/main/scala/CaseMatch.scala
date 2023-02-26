object CaseMatch {
  def main(args: Array[String]): Unit = {
    val a: A = new A("alice",19)

    val result: String = a match {
      case A("alice", 18) => "alice, 18"
      case _ => "else"
    }

    println(result)



    val b: B = new B("alice", 24)
    val res: String = b match {
      case B("bob", 24) => "bob 24"
      case _ => "else"
    }

    println(res)
  }
}


class A(val name: String, val age: Int)

object A {
  def apply(name: String, age: Int): A = new A(name, age)

  // 拆解对象属性 用来对象比对
  def unapply(a: A): Option[(String, Int)] = {
    if (a == null)
      None
    else
      Some((a.name, a.age))
  }
}


// 样例类 主构造器内的参数自动提升为属性 不需要加val或var 并且伴生对象 伴生对象中的apply和unapply方法都已自动生成
case class B(name: String, age: Int)

