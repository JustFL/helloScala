import java.io.File
import scala.io.Source

object MethodImplicit {
  def main(args: Array[String]): Unit = {

    val f = new File(MethodImplicit.getClass.getResource("actress.txt").getFile)
    import MyImplicit._
    println(f.readAll)


    // 定义隐式类使Int转化为MyRichInt
    implicit class MyRichInt(val i: Int) {
      def mymax(n: Int) = if (i > n) i else n
    }

    // Int本身没有mymax方法 但是会隐式转化为上述的隐式类MyRichInt 具备了mymax方法
    println(12.mymax(9))


  }
}

// 自定义RichFile类
class RichFile(var file: File) {
  def readAll: String = Source.fromFile(file).mkString
}

// 方法的隐式转换 file没有readAll方法 但是RichFile中有 实现File到RichFile的隐式转换
object MyImplicit {
  implicit def file2Rich(file: File): RichFile = new RichFile(file)
}
