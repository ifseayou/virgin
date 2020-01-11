package com.isea.penis.to10

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/6 21:30
  * @target:请实现一个函数 ，
  *                将一个字符串中的每个空格替换成“%20”。
  *      例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
  */
object NumS2 {
  // 使用一个匿名函数来解决
  val replace = (str:String)=>{
    str.map( t => if (t == ' ') '%' else t)
  }
}
