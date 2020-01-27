package com.isea.penis.to20

/**
  * @author ifseayou@gmail.com
  * @date 2020/1/24 18:12
  * @target:操作给定的二叉树，将其变换为源二叉树的镜像。
  *      源二叉树
  *            8
  *          /  \
  *        6   10
  *      / \  / \
  *     5  7 9 11
  *      镜像二叉树
  *            8
  *         /  \
  *        10   6
  *      / \  / \
  *     11 9 7  5
  *      ！！！ 左边和右边调换，然后在递归左子树和右子树
  */
object NumS18 {
  def mirror(root:TreeNode){
    var tmp : TreeNode = null
    if (root != null){
      tmp = root.left
      root.left = root.right
      root.right = tmp
      if (root.left != null) mirror(root.left)
      if (root.right != null) mirror(root.right)
    }
  }
}
