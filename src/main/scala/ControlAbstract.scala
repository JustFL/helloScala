object ControlAbstract {
  def main(args: Array[String]): Unit = {

    // 传值参数
    def f1(x: Int): Int = {
      println("f1 is executed")
      x + 2
    }
    println(f1(2))

    println("=============================")

    // 传名参数 参数不是变量值 而是代码块  =>Int表示一个返回Int类型的代码块
    def f2(x: => Int): Unit = {
      println(x)
      println(x)
    }

    f2(f1(3))

  }
}
