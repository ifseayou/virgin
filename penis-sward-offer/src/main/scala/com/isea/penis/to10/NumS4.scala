package com.isea.penis.to10

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/9 17:20
  * @target: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
  *          例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
  *          !!! 注意这里已经强调过了没有重复的数字
  */
object NumS4 {

  def reConstructBinaryTree(pre:Array[Int])(in:Array[Int]):TreeNode = {
    return reConstructBinaryTree(pre,0,pre.length - 1,in,0,pre.length -1)
  }

  private def reConstructBinaryTree(pre:Array[Int],preL:Int,preR:Int,in:Array[Int],inL:Int,inR:Int):TreeNode = {
    if (preL > preR || inL > inR) return null
    val root:TreeNode = new TreeNode()
    root.value = pre(preL)
    var bound = false
    for ( i <- 0 until in.length if !bound){
      if (in(i) == pre(preL)){
        root.left = reConstructBinaryTree(pre,preL + 1, preL + i - inL ,in, inL, i - 1)
        root.right = reConstructBinaryTree(pre,preL + i - inL + 1,preR,in,i + 1,inR)
        bound = true
      }
    }
    return  root
  }

  class TreeNode{
    var value : Int = _
    var left: TreeNode = null
    var right: TreeNode = null
  }
}

