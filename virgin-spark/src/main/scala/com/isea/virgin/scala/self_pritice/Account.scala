package com.isea.virgin.scala.self_pritice

class Account {
  private var name: String = _
  private var balance: Double = _
  private var password: String = _

  def setName(name: String): Unit = {

    if (name.length == 2 || name.length == 3 || name.length == 4) {
      this.name = name
    } else {
      throw new IllegalArgumentException("Illegal param...")
    }
  }

  def setBalance(balance: Double): Unit = {
    if (balance < 20) {
      throw new IllegalArgumentException("Illegal param...")
    } else {
      this.balance = balance;
    }
  }

  def setPassword(password : String): Unit ={
    if (password.length != 6){
      throw new IllegalArgumentException("Illegal param...")
    }else {
      this.password = password;
    }
  }

  def transfer(name : String,password : String, money : Double): Unit ={

    if (money < 0){
      throw new IllegalArgumentException("Illegal param...")
    }else {

    }
  }
}


class AccountTest {}