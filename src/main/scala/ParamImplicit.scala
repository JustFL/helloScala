/**
 * 参数隐式转换
 */
class Specical(var name: String)

class Older(var name: String)

class Child(var name: String)

//这里将Older类型和Child类型转化为了Spceical类型
object ParaImp {
  implicit def toSpec(old: Older): Specical = new Specical(old.name)

  implicit def toSpec(chi: Child): Specical = new Specical(chi.name)
}

object TicketHouse {
  def buyTicket(specical: Specical) = println(specical.name + " got ticket")
}

object ParamImplicit {
  def main(args: Array[String]): Unit = {
    TicketHouse.buyTicket(new Specical("dengchao"))
    import ParaImp._
    TicketHouse.buyTicket(new Older("chenhe"))
    TicketHouse.buyTicket(new Child("luhan"))


    implicit val str: String = "alice"
    def sayHello()(implicit name: String) = println("hello " + name)
    def sayHi(implicit name: String) = println("hi " + name)

    sayHello()
    sayHello
    sayHi
    //sayHi()

    // 注意如果同时有隐式值和默认值 隐式值会覆盖默认值

    // 简单写法 参数列表里不写任何参数 在方法体中使用implicitly方法表明需要一个String类型的参数 则编译器会自动寻找String类型的参数补充到整理
    def bye(): Unit = println("bye " + implicitly[String])
    bye

  }
}
