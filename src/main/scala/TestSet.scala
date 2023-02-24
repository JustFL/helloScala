import scala.collection.mutable

object TestSet {
  def main(args: Array[String]): Unit = {

    // Set默认是不可变集合 数据无序 数据不可重复
    val s1 = Set(1, 2, 3, 3)
    println(s1)

    val s1_1: Set[Int] = s1 + 20
    println(s1_1)

    // 合并
    val s1_2: Set[Int] = s1 ++ s1_1
    println(s1_2)

    // 删除元素
    val s1_3 = s1 - 1
    println(s1_3)


    // 创建可变集合
    val s2 = mutable.Set(1, 2, 3, 4, 5)

    // 集合添加元素
    s2.add(9)
    println(s2)

    // 删除数据
    s2.remove(5)
    println(s2)


  }
}
