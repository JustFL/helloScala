import scala.collection.mutable.ListBuffer

object TestList {
  def main(args: Array[String]): Unit = {

    // List默认为不可变集合
    val l1: List[Int] = List(1)

    // 取指定数据 但是不可赋值
    println(l1(0))


    // List增加数据::的运算规则从右向左
    val l2 = -1 :: 0 :: l1
    println(l2)


    // 空集合Nil
    val l3 = 1 :: 2 :: Nil
    println(l3)


    // 添加元素
    val l4 = 0 +: l3
    println(l4)
    val l41 = l3 :+ 3
    println(l41)


    // List间合并
    val l5 = l2 ::: l4
    println(l5)

    val l6 = l2 ++ l4
    println(l6)


    println("----------可变List----------")
    // 创建一个可变List
    val lb1 = ListBuffer(1)

    // 向集合中添加数据
    lb1.append(2)

    // 在某个位置加入多个元素
    lb1.insert(0, 3, 4)
    println(lb1)

    // 修改数据
    lb1(2) = 8
    lb1.update(1, 9)
    println(lb1)

    // 删除某个索引位置的值
    lb1.remove(1)

    // 删除某个值
    lb1.-=(1)
    println(lb1)

    println("---------------------------")
    // 两个list连接
    val lb2: ListBuffer[Int] = ListBuffer(99)
    val lb3: lb1.type = lb1 ++= lb2
    println(lb3)



  }
}
