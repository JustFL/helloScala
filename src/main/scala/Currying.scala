object Currying {
  def main(args: Array[String]): Unit = {

    // 适用场景 当多个参数中的某些参数的值比较固定时 可以将这些参数的值先赋予 返回一个新的包含剩余参数的新函数 实现了参数的复用

    // 两数相加
    def add(a: Int, b: Int) = a + b

    // 当其中一个参数固定为1时
    def addOne(a: Int) = a + 1

    // 当其中一个参数固定为2时
    def addTwo(a: Int) = a + 1

    // 当固定的参数可能为很多值的时候 先传入固定参数返回一个函数 然后将另外的参数传入到返回的函数中
    def addfixed(a: Int): Int => Int = {
      //这种定义中 内层函数使用了外部函数的值 这种用法称为闭包
      def f(b: Int): Int = {
        a + b
      }
      f
    }

    // 传入固定参数值 得到函数
    val f1: Int => Int = addfixed(5)

    // 调用函数 得到固定值和另外值的两数之和
    println(f1(5))

    println("==========================================")

    // 柯里化 把一个参数列表的多个参数 变成多个参数列表
    def addCurrying(a: Int)(b: Int): Int = a + b

    // 柯里化后 传入一个参数返回一个函数
    val f2: Int => Int = addCurrying(1)

    // 继续传入第二个参数 可以看到柯里化和上面的效果一致
    println(f2(2))

  }
}
