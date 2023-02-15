import scala.collection.mutable.ListBuffer

object TestList {
  def main(args: Array[String]): Unit = {

    // List默认为不可变集合
    val l1: List[Int] = List(1)

    // 取指定数据
    println(l1(0))


    // List增加数据::的运算规则从右向左
    val l2 = -1 :: 0 :: l1
    println(l2)


    // 空集合Nil
    val l3 = 1 :: 2 :: Nil
    println(l3)


    // 添加到第一个元素位置
    val l4 = l3.+:(0)
    println(l4)
    val l41 = -1 :: l3
    println(l41)
    val l42 = -2 +: l3
    println(l42)
    val l43 = l3.::(-3)
    println(l43)


    // List间合并
    val l5 = l2 ::: l4
    println(l5)


    println("----------可变List----------")
    // 创建一个可变List
    val lb1 = ListBuffer(1)

    // 向集合中添加数据
    lb1.+=(2)
    lb1.append(3)
    lb1.insert(0, 0)
    println(lb1)


    // 修改数据
    lb1(2) = 8
    lb1.update(3, 9)
    println(lb1)


    // 删除数据
    lb1.-=(1)
    lb1.remove(1)
    println(lb1)


  }
}
