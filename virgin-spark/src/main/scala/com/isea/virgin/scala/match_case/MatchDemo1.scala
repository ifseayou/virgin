package com.isea.virgin.scala.match_case

object MatchDemo1 {
  def main(args: Array[String]): Unit = {
    val nameStr = "Aclice,Tom,Thomas"
    nameStr match{
      /**
        *  Names(first,second,third)会调用unapplySeq，如果返回了Some会将结果赋值给first，second，third
        *  unapplySeq返回的参数的个数要和case后要求的参数个数相等，返回None则表示失败了。
        */
      case Names(first,second,third) => {
        println("The string contains three people's names")
        // 打印字符串：
        println(s"$first,$second,$third")
      }
      case _ => println("Nothing match....")
    }
  }
  /**
    * The string contains three people's names
    * Aclice,Tom,Thomas
    */
}
object Names{
  def unapplySeq(str : String) : Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(",")) else None
  }
}
