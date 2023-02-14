object FunctionAsReturnValue {
  def main(args: Array[String]): Unit = {

    // 函数做为另外一个函数的返回值
    def f1: Int => Unit = {

      def f2(i: Int): Unit = {
        println(i + 1)
      }

      f2
    }

    // 直接调用f1得到的是f1的返回值: 函数f2
    println(f1)

    // 调用f2函数
    f1(3)

    // 输出f2函数的返回值
    println(f1(3))


    // 再举一个例子 =后表示传入一个Int 返回Unit的匿名函数 此匿名函数作为f3函数的返回值
    def f3(name: String) = (age: Int) => println("my name is " + name + " my age is " + age)

    // f3("bob")会返回一个函数 传入这个函数的参数30
    f3("bob")(30)
  }
}
