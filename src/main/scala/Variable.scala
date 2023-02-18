object Variable {
  def main(args: Array[String]): Unit = {

    // 类型确定后不能修改
    // 变量常量必须有初始值

    val c1 = 'a'
    val c2 = '\n'
    val c3 = '\\'
    val c4 = '\"'
    val c5 = '8'
    print(c1 + "夏川あかり" + c2 + "夏川あかり" + c3 + "夏川あかり" + c4)
    println()

    // 字符类型在底层存储的是一个数字 对应的是ASCII码
    val i1: Int = c1
    println(i1)

    val i2: Int = c5
    println(i2)

    // Unit类型表示空值 Unit只有一个实例值()
    def testUnit: Unit = {}

    println(testUnit)


    // Null类表示空引用 只有一个实例对象null
    class Cat()
    var cat = new Cat();
    cat = null
    println(cat)


    // Nothing是其他任意类型的子类 用在一个函数没有明确返回值的时候 这里返回一个异常
    def testNothing(i: Int): Int = {
      if (i == 0) {
        throw new Exception()
      } else {
        return i
      }
    }

    println(testNothing(1))
    println(testNothing(0))

  }
}
