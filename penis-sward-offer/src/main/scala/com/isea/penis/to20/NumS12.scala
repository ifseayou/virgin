package com.isea.penis.to20

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 9:20
  * @target:
  */
object NumS12 {
  val power = (base:Double,exp:Int)=>{
    var res = 1.0;
    if (exp > 0){
      for(i <- 1 to exp){
        res = res * base
      }
    }else{
      for(i<- exp to -1){
        res = res * base
      }
      res =  1.0 / res
    }
    res
  }
}
