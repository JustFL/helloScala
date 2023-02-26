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

/**
 * 样例类
 * 1、构造器中的参数如果不被声明为 var 的话，它默认的话是 val 类型的，但一般不推荐将构造器中的参数声明为 var
 * 2、自动创建伴生对象，同时在里面给我们实现子 apply 方法，使得我们在使用的时候可以不直接显示地 new 对象
 * 3、伴生对象中同样会帮我们实现 unapply 方法，从而可以将 case class 应用于模式匹配
 * 4、实现自己的 toString、hashCode、copy、equals 方法
 * 5、case class 主构造函数里面没有修饰符，默认的是 val
 *
 */
case class B(name: String, age: Int)

