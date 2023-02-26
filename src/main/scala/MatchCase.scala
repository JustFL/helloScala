import scala.util.Random

object MatchCase extends App {

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

  println("============================================")

  // 模式匹配的基本语法
  val arr1 = Array(1, 2, 3)
  val no1 = arr1(Random.nextInt(arr1.length))
  no1 match {
    case 1 => println("dengchao")
    case 2 => println("luhan")
    case _ => println("chenhe")
  }

  // 模式匹配对各种类型进行匹配
  val arr2 = Array(1, true, "dengchao", Array(1, 2, 3))
  val no2 = arr2(Random.nextInt(arr2.length))
  no2 match {
    case a: Int => println("匹配到了数字: " + a)
    case b: Boolean => println("匹配到了boolean: " + b)
    case c: String => println("匹配到了字符串: " + c)
    case d: Array[Int] => println("匹配到了数组: " + d.toBuffer)
  }

  /*
   * 模式匹配对存在或者不存在进行匹配 map.get()方法如果key值存在
   * 返回一个Some()包装好的值 不存在就返回一个None
   */
  val map1 = Map(("a", 1), ("b", 2))
  val no3 = map1.get("c")
  no3 match {
    case Some(x) => println("取到map中的值为" + x)
    case None => println("map中不存在对应的key")
  }


  // 模式匹配某种复杂数据类型对应位置上的值
  val list1 = List(1, 2, 3, 4, 5, 6)
  list1 match {
    case List(1, 2, x, 4, 5) => println(x)
    case 1 :: 2 :: Nil => println("这是一个只有1，2两个元素的list")
    case 1 :: 2 :: x => println(x)
    case _ => println("无法识别的list")
  }

  /*样例类 匹配自定义类型*/
  val obj1: AnyRef = Teacher(5, "dengchao")
  obj1 match {
    case Teacher(id, name) => println("This is a teacher " + id + name)
    case Student(id, name, age) => println("this is a student " + id + name + age)
  }

  /*偏函数原型*/
  def func1(t: Int): String = {
    t match {
      case 1 => println("1"); "1"
      case 2 => println("2"); "2"
    }
  }

  func1(2)
  /*偏函数*/
  val flag = true

  def func2: PartialFunction[Int, String] = {
    case 1 => "1"
    case 2 => "2"
  }

  println("func2:" + func2(2))
}


case class Student(id: Int, name: String, age: Int)

case class Teacher(id: Int, name: String)
