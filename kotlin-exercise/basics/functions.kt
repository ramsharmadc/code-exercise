fun sayHello(greeting: String, vararg itemsToGreet: String){
    itemsToGreet.forEach {
        itemToGreet  -> 
            println("$greeting $itemToGreet")
    }
}

fun main(args: Array<String>) {
    val interestingThings = arrayOf("Kotlin", "Coding", "Clean")

    sayHello(greeting="Hello", itemsToGreet= *interestingThings)
}