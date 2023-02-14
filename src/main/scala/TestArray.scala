import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object TestArray {
  def main(args: Array[String]): Unit = {

    /*
      不可变数组
     */
    // 第一种不可变数组定义方式
    val arr1 = new Array[Int](4)
    println(arr1.length)

    // 修改某个元素的值
    arr1(3) = 10

    // 采用方法的形式给数组赋值
    arr1.update(0, 1)

    // 遍历数组
    println(arr1.mkString(","))

    // 普通遍历
    for (i <- arr1) {
      println(i)
    }

    // 简化遍历
    arr1.foreach(println)

    // 增加元素 由于是不可变数组 增加元素其实是产生新的数组
    println(arr1)
    val arr2: Array[Int] = 2 +: 2 +: arr1 :+ 5 :+ 5
    println(arr2)
    arr2.foreach(println)


    // 第二种不可变数组定义方式 本质是调用apply方法
    var arr3 = Array(1, 3, "bobo")

    for (i <- arr3) {
      println(i)
    }

    println("--------------------------")

    /*
      创建并初始赋值可变数组
     */
    val arr4 = ArrayBuffer[Any](1, 2, 3)

    println("arr4.hash=" + arr4.hashCode())

    // 追加数据
    arr4.+=(4)
    arr4 += (4)
    println(arr4.mkString(","))

    // 向数组最后追加数据
    arr4.append(5, 6)
    arr4.foreach(println)

    println("-------------------------")
    // 删除
    arr4.remove(3,1)
    arr4.foreach(println)

    // 向指定的位置插入数据
    arr4.insert(0, 7, 8)
    println(arr4.mkString(","))
    println("arr4.hash=" + arr4.hashCode())

    // 修改元素
    arr4(1) = 9
    arr4.foreach(println)


    // .toArray 返回一个新的定长数组集合 原可变数组不变
    val arr5: Array[Any] = arr4.toArray
    println(arr5.mkString(","))

    // .toBuffer 返回一个新的变长数组 原定长数组不变
    val arr6: mutable.Buffer[Any] = arr5.toBuffer
    println(arr6.mkString(","))

  }
}
