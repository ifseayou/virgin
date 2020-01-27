package com.isea.penis.to20

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 11:27
  * @target: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
  */
object NumS17 {

  def doesTree1HasTree2(node1: TreeNode, node2: TreeNode): Boolean = {
    if (node2 == null) return true
    if (node1 == null) return false
    if (node1.value != node1.value) return false
    return doesTree1HasTree2(node1.left,node2.left) && doesTree1HasTree2(node1.right,node2.right)
  }

  def hasSubtree(root1:TreeNode, root2:TreeNode):Boolean ={
    var flag = false
    if (root1 != null && root2 != null){
      if (root1.value == root2.value) flag = doesTree1HasTree2(root1,root2)
      if (!flag) flag = hasSubtree(root1.left,root2)
      if (!flag) flag = hasSubtree(root1.right,root2)
    }
    return flag
  }
}
case class TreeNode(var value:Int,var left:TreeNode,var right: TreeNode)