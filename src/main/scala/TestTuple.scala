object TestTuple {
  def main(args: Array[String]): Unit = {

    // 声明元组的方式 (元素1, 元素2, 元素3)
    val t1: (Int, String, Boolean) = (40, "bobo", true)


    // 通过元素的顺序进行访问 调用方式 _顺序号
    println(t1._1)
    println(t1._2)
    println(t1._3)

    // 通过索引访问数据
    println(t1.productElement(0))

    // 通过迭代器访问数据
    for (t <- t1.productIterator) {
      println(t)
    }

    println(t1)

    // Map中的键值对其实就是元组 只不过元组的元素个数为2 称之为对偶
    val m1 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val m2 = Map(("a", 1), ("b", 2), ("c", 3))

    m1.foreach(tuple => {
      println(tuple._1 + " = " + tuple._2)
    })

    println(m2)
  }
}
