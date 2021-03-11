package async.demo

import scala.concurrent.{ExecutionContext, Future}

object AsyncDemo extends App {

  val strt = System.currentTimeMillis();

  def info(msg: String) = printf("%.2f: %s\n",
    (System.currentTimeMillis() - strt) / 1000.0, msg)

  case class Dish(name: String) {
    def +(other: Dish) = Dish(s"$name with ${other.name}")
  }

  def cook(what: String): Dish = {
    Thread.sleep(1000L)
    info("cooked")
    Dish(what)
  }

  def serve(dish: Dish): Unit = {
    info(s"Here's your ${dish.name}, sir!")
  }

  val s = cook("steak")
  val p = cook("potato")
  serve(s + p)

}
