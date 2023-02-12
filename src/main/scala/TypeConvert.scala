/**
 * 有多种类型的数据混合运算时 系统首先自动将所有数据转换成精度大的那种数据类型 然后再进行计算
 * 把精度大的数值类型赋值给精度小的数值类型时会报错
 *
 * 将数据由高精度转换为低精度 就需要使用到强制转换
 */
object TypeConvert {
  def main(args: Array[String]): Unit = {


    // 基本类型转String类型 将基本类型的值+"" 即可
    var str1: String = true + ""
    var str2: String = 4.5 + ""
    var str3: String = 100 + ""
    println(str1 + "-" + str2 + "-" + str3)

    //String类型转基本数值类型 调用相关API
    var s1: String = "12"
    var n1: Byte = s1.toByte
    var n2: Short = s1.toShort
    var n3: Int = s1.toInt
    var n4: Long = s1.toLong
    println(n1 + "-" + n2 + "-" + n3 + "-" + n4)


  }
}
