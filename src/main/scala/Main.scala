import com.rcosnita.scala.examples.native.{Pizza, Mozzarella, Pepperoni, NativePizzaService}

object Main {
  def main(args: Array[String]): Unit = {
    println("Starting to work baby ...")
    val pizza: Pizza = Pizza("Margherita", Seq(Mozzarella, Pepperoni))
    val svc: NativePizzaService = NativePizzaService()
    svc.allocate(pizza)
  }
}
