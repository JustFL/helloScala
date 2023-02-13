/**
 * 至简原则 能省则省
 */
object FunctionOmit {
  def main(args: Array[String]): Unit = {

    println("---函数标准写法 如果有return 则不能省略返回值类型---")
    def f(name: String): String = {
      return "hello " + name
    }
    println(f("alice"))


    println("---return可以省略 Scala会使用函数体的最后一行代码作为返回值---")
    def f1(name: String): String = {
      "hello " + name
    }
    println(f1("alice"))


    println("---如果函数体只有一行代码 可以省略花括号---")
    def f2(name: String): String = "hello " + name
    println(f2("alice"))


    println("--返回值类型如果能够推断出来 那么可以省略---")
    def f3(name: String) = "hello " + name
    println(f3("alice"))


    println("---如果函数明确声明unit 那么即使函数体中使用return关键字也不起作用---")
    def f4(name: String): Unit = {
      return "hello " + name
    }
    println(f4("alice"))

    println("---如果函数无返回值类型 可以省略等号---")
    // 将无返回值的函数称之为过程
    def f5(name: String) {
      println("hello " + name)
    }
    println(f5("alice"))

    println("---如果函数无参 但是声明了参数列表 那么调用时小括号可加可不加---")
    def f6() = "alice"
    println(f6())
    println(f6)

    println("---如果函数没有参数列表 那么小括号可以省略 调用时小括号必须省略---")
    def f7 = "alice"
    println(f7)

    println("---函数名和def都可以省略 称为匿名函数或者lambda表达式---")
    (name: String) => { println(name) }

  }
}
