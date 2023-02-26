import scala.util.Random

object MatchCase extends App {
  // 变量或者常量+match 对值进行匹配
  val arr1 = Array(1, 2, 3)
  val no1 = arr1(Random.nextInt(arr1.length))

  val str1: String = no1 match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }
  println(str1)

  val a = 15
  val b = 29
  var operator: Char = '+'

  val result = operator match {
    case '+' => a + b
    case '-' => a - b
    case '*' => a * b
    case '/' => a / b
    case _ => "illegal"
  }
  println(result)


  // 模式守卫 匹配某个范围的数据
  def level(score: Int): String = score match {
    case a if a >= 60 => "及格"
    case b if b < 60 => "不及格"
    case _ => "illegal"
  }

  println(level(70))

  def abs(x: Int) = x match {
    case x if x >= 0 => x
    case x if x < 0 => -x
  }

  println(abs(102))


  def describe(x: Any) = x match {
    case 5 => "Int five"
    case false => "Boolean false"
    case 5.5 => "Double 5.5"
    case "hello" => "Stirng hello"
    case '+' => "Char +"
    case _ => 999
  }

  println(describe(5))
  println(describe(5.5))
  println(describe(false))
  println(describe("hello"))
  println(describe('+'))
  println(describe(9))


  // 匹配类型
  def typeMatch(x: Any) = x match {
    case i: Int => "Int"
    case str: String => "String"
    case d: Double => "Double"
    case b: Boolean => "Boolean"
    case l: List[_] => "List"
    case something => "something else " + something
  }

  println(typeMatch(6))
  println(typeMatch(6.6))
  println(typeMatch("bye scala"))
  println(typeMatch(true))
  println(typeMatch(Map(1 -> 1)))
  println(typeMatch(List(1)))


  // 对集合进行精确的匹配
  def listMatch(arr: Array[Int]) = arr match {
    case Array(0) => "0"
    case Array(x, y) => x + "," + y
    case Array(0, _*) => "以0开头的数组"
    case _ => "something else"
  }

  println(listMatch(Array(2, 3)))
  println(listMatch(Array(0)))
  println(listMatch(Array(0, 1, 5)))
  println(listMatch(Array(4, 5, 6)))


  println("-----------------")

  // 对元组进行匹配
  def tupleMatch(tuple: Any) = tuple match {
    case (0, _) => "第一个元素是0的元组"
    case (x, 0) => x + "," + 0
    case (x, y) => x + "," + y
    case (x, 2, _) => x + "," + "2" + "," + "someting else"
    case _ => "something else"
  }

  println(tupleMatch((1, 2, 3)))
  println(tupleMatch((1, 2)))
  println(tupleMatch((1, 0)))
  println(tupleMatch((0)))
  println(tupleMatch((0, 99)))


  println("--------------------")
  // 打印元组第一个元素
  for (elem <- Array(("a", 1), ("b", 2), ("c", 3))) {
    println(elem._1 + "," + elem._2)
  }

  for ((word, count) <- Array(("a", 1), ("b", 2), ("c", 3))) {
    println(word + ":" + count)
  }

  for ((word, _) <- Array(("a", 1), ("b", 2), ("c", 3))) {
    println(word)
  }

  for (("a", count) <- Array(("a", 1), ("b", 2), ("c", 3))) {
    println(count)
  }

  println("--------------------")

  // 在元组声明时进行匹配
  var (id, name, age): (Int, String, Int) = (100, "zs", 20)
  println((id, name, age))
  println("--------------")

  // 遍历集合中的元组
  var list: List[(String, Int)] = List(("a", 1), ("b", 2), ("c", 3))
  //println(list.map(t => (t._1, t._2 * 2)))
  println(
    list.map {
      case (word, count) => (word, count * 2)
    }
  )


}


