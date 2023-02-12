object Variable {
  def main(args: Array[String]): Unit = {

    // Unit类型表示没有返回值 Unit只有一个实例值()
    def testUnit : Unit = {}
    println(testUnit)


    // Null类只有一个实例对象null 可以赋值给任意引用类型AnyRef 但是不能赋值给值类型AnyVal
    class Cat()
    var cat = new Cat();
    cat = null
    println(cat)



  }
}
