import ExplainObject.school

class ExplainObject(name: String, age: Int) {
  def printInfo(): Unit = {
    // 字符串 通过+号连接
    println(name + " " + age + " " + ExplainObject.school)
    // printf 用法字符串 通过%传值
    printf("name=%s age=%d school=%s\n", name, age, school)
    //
    println(s"name is ${name}, age is ${age}, school is ${school}")
  }
}

object ExplainObject {
  val school = "javbus"

  def main(args: Array[String]): Unit = {
    val alice = new ExplainObject("alice", 20)
    alice.printInfo()
  }
}

