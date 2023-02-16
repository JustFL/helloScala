import scala.collection.mutable

object TestMap {
  def main(args: Array[String]): Unit = {

    // 创建不可变集合Map
    val m1 = Map("a" -> 1, "b" -> 2, "c" -> 3)

    // 访问数据
    for (key <- m1.keys) {
      // 使用get访问map集合的数据 会返回特殊类型Option(选项):
      // 有值（Some）
      // 无值（None）
      println(key + "=" + m1.get(key).get)
    }

    // 如果key不存在 返回0
    println(m1.get("d").getOrElse(0))
    println(m1.getOrElse("d", 0))

    // 循环打印
    m1.foreach((kv) => {
      println(kv)
    })
    println(m1)

    println("-----------------------")

    // 创建可变集合
    val m2 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)

    // 向集合增加数据
    m2.+=("d" -> 4)
    println(m2)

    // 将数值4添加到集合 并把集合中原值1返回
    val maybeInt: Option[Int] = m2.put("a", 4)
    println(maybeInt.getOrElse(0))
    println(m2)

    // 删除数据
    m2.-=("b", "c")
    println(m2)

    // 修改数据
    m2.update("d",5)
    m2("d") = 6
    println(m2)

  }
}
