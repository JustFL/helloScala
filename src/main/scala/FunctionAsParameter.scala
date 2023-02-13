object FunctionAsParameter {
  def main(args: Array[String]): Unit = {

    // 将匿名函数赋给一个变量
    val f1 = (name: String) => { println(name) }
    f1("alice")

    println("--------------------------")

    // 将函数作为参数传递给另外一个函数
    def f2(func: String => Unit): Unit = {
      func("bob")
    }

    // 调用函数 传递一个f1函数作为参数
    f2(f1)

    // 调用函数 传递一个匿名函数作为参数
    f2( (name: String) => { println(name) } )

    // 匿名函数简化原则
    // 匿名函数的参数类型可以省略 会根据形参进行自动推导
    f2( (name) => { println(name) } )


    // 参数类型省略之后 发现只有一个参数 则圆括号可以省略 其他情况 没有参数和参数超过1的永远不能省略圆括号
    f2( name => { println(name) } )


    // 匿名函数如果只有一行 则大括号也可以省略
    f2( name => println(name) )


    // 如果参数只出现一次 则参数省略且后面参数可以用_代替
    f2( println(_) )


    // 如果参数只出现一次 则参数省略且后面参数可以用_代替
    f2( println(_) )

    //
    f2( println )


    // 传递的函数有两个参数
    def calculator(a: Int, b: Int, op: (Int, Int) => Int): Int = { op(a, b) }


    // 匿名函数作为第三个参数
    println( calculator( 2, 3, (x: Int, y: Int) => {x + y} ) )


    // 匿名函数如果只有一行 则大括号也可以省略
    println( calculator( 2, 3, (x: Int, y: Int) => x + y ) )


    // 匿名函数的参数类型可以省略 会根据形参进行自动的推导
    println( calculator( 2, 3, (x, y) => x + y ) )


    // 匿名函数的参数只出现一次 则参数省略且后面参数可以用_代替
    println( calculator( 2, 3, _ + _ ) )
    println( calculator( 2, 3, _ - _ ) )
    println( calculator( 2, 3, -_ + _ ) )


  }
}
