package com.isea.learn.flink.grammer


/**
  * @author isea_you
  * @date 2019/8/28
  * @time 11:43
  * @target:
  */
object ScalaGrammer {
  def main(args: Array[String]): Unit = {

  }
}

class PersonS(val name:String,val age :Int){
  print("PersonS is coming...")
  // print语句是主构造器的一部分，每当有对象被构造出来的时候，上述的代码就会被执行
  // 当你需要在构造的过程中配置某个字段的时候，特别有用
}

