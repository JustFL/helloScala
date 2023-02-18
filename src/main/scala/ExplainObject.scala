import ExplainObject.school

class ExplainObject(name: String, age: Int) {
  def printInfo(): Unit = {
    // 字符串 通过+号连接
    println(name + " " + age + " " + ExplainObject.school)
    // 占位符 通过%传值
    printf("name=%s age=%d school=%s\n", name, age, school)
    // 字符串模板
    println(s"name is ${name}, age is $age, school is ${school}")

    // 三引号
    println(
      s"""
         |select
         |  *
         |from
         |  student
         |where
         |  name = $name and age > ${age}
         |""".stripMargin)
  }
}

object ExplainObject {
  val school = "javbus"

  def main(args: Array[String]): Unit = {
    val alice = new ExplainObject("alice", 20)
    alice.printInfo()
  }
}

