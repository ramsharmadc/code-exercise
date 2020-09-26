package demo.scala

object HelloWorld extends App {

  println("Hello Scala World");
  println("Lets do some Scala");

  val x = 3 // immutable
  println("x -> " + x)

  var y = x + 1 //mutable
  println("y -> " + y);

  val s = "This is a String"
  println(s);

  val a = 2;

  if (a % 2 == 0) {
    println("even")
  } else {
    println("odd")
  }

  var result = a match {
    case 2 => "Two"
    case 3 => "Three"
  }

  println(result)

  def bento: (Sushi, Sushi) = (new Sashimi, new Onigiri)

  print(bento)

  println("Echo")
}