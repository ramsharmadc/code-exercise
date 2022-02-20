package hello

fun printMessage(msg: String) {
    println(msg)
}

fun printMessageWithPrefix(msg: String, prefix: String = "Info") {
    println("$prefix: $msg")
}

fun main(args: Array<String>) {
    println("Hello World of **Kotlin**")
    printMessage("**Kotlin** messaging system")
    printMessageWithPrefix("**kotlin** messaging system")
}