import scala.collection.mutable

object TestSet {
  def main(args: Array[String]): Unit = {

    // Set默认是不可变集合 数据无序 数据不可重复
    val s1 = Set(1, 2, 3, 3)
    println(s1)


    // 创建可变集合
    val s2 = mutable.Set(1, 2, 3, 4, 5)

    // 集合添加元素
    s2 += 8
    println(s2)

    // 向集合中添加元素返回一个新的 Set
    val s3 = s2.+(9)
    println("set2 = " + s2)
    println(s3)

    // 删除数据
    s3 -= (5)
    println(s3)


  }
}
