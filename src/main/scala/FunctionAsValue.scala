object FunctionAsValue {
  def main(args: Array[String]): Unit = {

    // 定义一个函数
    def addOne(x: Int): Int = {
      println("addOne is execute")
      x + 1
    }

    // 调用函数 并将返回值赋予res
    var res = addOne(5)
    println(res)

    // 将函数作为值传递 或者加'空格+_'  或者 直接申明函数
    val f1 = addOne _
    val f2: Int => Int = addOne
    println(f1)
    println(f2)

    println(f1(21))

    println("=============")
    // 定义一个无参的函数
    def f3 = {
      println("f3 is execute")
      1
    }

    val f4: () => Int = f3 _
    println(f4)
    println(f4())

  }
}
