package com.isea.virgin.scala.build

object TraitBuild {
  def main(args: Array[String]): Unit = {
    var kk = new KK with CC with DD
    /**  创建类的时候，动态混入特质
      * EE...
      * KK...
      * AA...
      * BB...
      * CC...
      * DD...
      */
  }}
trait AA{
  println("AA...")}
trait BB extends AA{
  println("BB...")}
trait CC extends BB{
  println("CC...")}
trait DD extends BB{
  println("DD...")}
class EE{
  println("EE...")}
class FF extends EE with CC with DD{
  println("FF...")}
class KK extends EE{
  println("KK...")}