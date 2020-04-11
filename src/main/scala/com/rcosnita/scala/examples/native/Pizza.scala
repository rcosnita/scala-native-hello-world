package com.rcosnita.scala.examples.native

import scalanative.native

sealed trait Topping

case object Pepperoni extends Topping
case object Mozzarella extends Topping

case class Pizza(name: String, toppings: Seq[Topping])

@native.link("demolib")
@native.extern
object DemoLib {
  def sayHello(str: native.CString): Unit = native.extern
}

class NativePizzaService {
  import scala.scalanative.native._

  def allocate(pizza: Pizza): Unit = {
//    val nativeStr = c"works as expected ..."
    Zone { implicit z =>
      val str = pizza.toString()
      val nativeStr = native.toCString(str)
      DemoLib.sayHello(nativeStr)
    }
  }
}

object NativePizzaService {
  def apply(): NativePizzaService = new NativePizzaService()
}
