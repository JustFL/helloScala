object Operator {
  def main(args: Array[String]): Unit = {

    // ==更加类似于Java中的equals
    val s1 = "abc"
    val s2 = new String("abc")

    println(s1 == s2)

    // 比较引用地址
    println(s1.eq(s2))


    // 在Scala所有运算符都是方法
    // 标准的加法运算
    val i: Int = 1.+(1)
    // 当调用对象的方法时 .可以省略
    val j: Int = 1 + (1)
    // 如果函数参数只有一个或者没有参数 ()可以省略
    val k: Int = 1 + 1
    println(i + "-" + j + "-" + k)

    println(1.toString())
    println(1 toString())
    println(1 toString)
  }
}
