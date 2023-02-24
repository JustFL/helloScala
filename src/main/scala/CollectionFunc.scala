import scala.collection.mutable

object CollectionFunc {
  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7)

    // 获取集合长度
    println(list.length)

    // 获取集合大小 等同于length
    println(list.size)

    // 迭代器
    for (elem <- list.iterator) {
      println(elem)
    }

    // 生成字符串
    println(list.mkString(","))

    // 是否包含
    println(list.contains(3))


    println("---衍生集合---")
    // 获取集合的头
    println("head:" + list.head)

    // 获取集合的尾（不是头的就是尾）
    println("tail:" + list.tail)

    // 集合最后一个数据
    println("last:" + list.last)

    // 集合初始数据（不包含最后一个）
    println("init:" + list.init)

    // 反转
    println("reverse:" + list.reverse)

    // 取前（后）n个元素
    println("take:" + list.take(3))
    println(list.takeRight(3))

    // 去掉前（后）n 个元素
    println("drop:" + list.drop(3))
    println(list.dropRight(3))


    val list1 = List(1, 2, 4)
    // 并集
    println(list.union(list1))

    // 交集
    println(list.intersect(list1))

    // 差集
    println(list.diff(list1))

    // 拉链 如果两个集合的元素个数不相等 那么会将同等数量的数据进行拉链 多余的数据省略不用
    println(list.zip(list1))

    // 滑窗
    list.sliding(2, 1).foreach(println)


    println("---简单计算函数---")
    // 求和
    println(list.sum)

    // 求乘积
    println(list.product)

    // 最大值
    println(list.max)

    // 最小值
    println(list.min)

    // 按照元素大小排序
    println(list.sortBy(x => x))

    // 按照元素的绝对值大小排序
    println(list.sortBy(x => x.abs))

    // 按元素大小升序排序
    println(list.sortWith((x, y) => x < y))

    // 按元素大小降序排序
    println(list.sortWith((x, y) => x > y))


    println("---高级计算函数---")
    // 过滤
    println(list.filter(x => x % 2 == 0))

    // 转化/映射
    println(list.map(x => x + 1))

    // 扁平化
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    println("nestedList:" + nestedList.flatten)

    // 扁平化+映射 flatMap相当于先进行map操作 在进行flatten操作
    val wordList: List[String] = List("hello world", "hello atguigu", "hello scala")
    println(wordList.flatMap(x => x.split(" ")))

    // 分组
    println(list.groupBy(x => x % 2))
    println(list.groupBy(x => {
      if (x % 2 == 0) "偶数" else "奇数"
    }))


    println("---Reduce---")
    // 将数据两两结合 实现运算规则
    val l1: List[Int] = List(1, 2, 3, 4)
    val i1: Int = l1.reduce((x, y) => x - y)
    println("i1:" + i1)

    val i2: Int = l1.reduceRight((x, y) => x - y)
    println(i2)


    // 第一个参数列表为初始值 第二个参数列表为简化规则
    val i3 = l1.fold(1)((x, y) => x - y)
    println(i3)

    val i4 = l1.foldRight(10)((x, y) => x - y)
    println(i4)

    // 两个Map的数据合并
    val map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = mutable.Map("a" -> 4, "b" -> 5, "d" -> 6)

    val map3: mutable.Map[String, Int] = map1.foldRight(map2)((tuple, map) => {
      map(tuple._1) = map.getOrElse(tuple._1, 0) + tuple._2
      map
    })
    println(map3)

    println("----------------------")
    val wordCountList = List("Hello Scala Hbase kafka", "Hello Scala Hbase", "Hello Scala", "Hello")
    wordCountList.flatMap(_.split(" ")).groupBy(word => word).mapValues(list => list.length).toList.sortWith(_._2 > _._2).take(3).foreach(println)
  }

}
