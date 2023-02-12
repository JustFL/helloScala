import scala.util.control.Breaks

object ProcessControl {
  def main(args: Array[String]): Unit = {
    // scala所有的操作都有返回值 {}是代码块 代码块中的最后一行就是返回值
    var a = 6
    var b = 5
    var c = if (a > b) b else a
    println(c)

    println("-------------for-------------")
    // for循环 Scala中for循环是有返回值的 如果被循环的是Map 返回的就是Map 被循环的是List 返回的就是List 以此类推
    for (i <- 1 to 5)
      println(i)

    println("-------------每隔2个打印-------------")
    for (i <- 1 to(5, 2))
      println(i)

    println("-------------循环步长-------------")
    for (i <- 1 to 10 by 2) {
      println("i=" + i)
    }

    println("-------------for循环中的yield会把当前的元素记下来 保存在集合中 循环结束后将返回该集合-------------")
    val arr = for (x <- 1 to(5, 2))
      yield x * 2

    println("-------------前闭后开的范围-------------")
    for (index <- 0 until arr.length)
      println(arr(index))

    println("-------------嵌套循环-------------")
    for (x <- 1 to 3; y <- 1 to 3 if x == y)
      println(x * y)

    println("-------------循环守卫 即循环保护式 保护式为true则进入循环体内部 为false则跳过 类似于continue-------------")
    for (i <- 1 to 5 if i != 2) {
      print(i + " ")
    }
    println()

    println("-------------引入变量-------------")
    for (i <- 1 to 3; j = 4 - i) {
      println("i=" + i + " j=" + j)
    }

    println("-------------倒序打印-------------")
    for (i <- 1 to 10 reverse) {
      println(i)
    }


    println("-------------Scala中使用breakable控制结构来实现break和continue功能-------------")
    Breaks.breakable(
      for (elem <- 1 to 10) {
        println(elem)
        if (elem == 5) Breaks.break()
      }
    )
    println("正常结束循环")

  }
}
