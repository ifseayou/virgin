package com.isea.penis.to10

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/15 20:54
  *
  * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
  * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
  * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
  */
object NumS6 {
  def minNumberInRotateArray(arr:Array[Int]):Int =  {
    if (arr == null || arr.length == 0) return 0
    var min = Int.MaxValue
    for(i <- arr){
      if (i < min) min = i
    }
    min
  }
}
