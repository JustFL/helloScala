import scala.io.Source

object FileIO {
  def main(args: Array[String]): Unit = {

    Source.fromFile("src\\main\\resources\\actress.txt").foreach(print)
    Source.fromFile(FileIO.getClass.getClassLoader.getResource("actress.txt").getPath).foreach(print)
  }
}
