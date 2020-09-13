package intro

fun main(args: Array<String>) {
    println("Hello Kotlin")
    
    var x = 5
    var y = 9

    var max = max(x, y, 18)

    println("max => "+max)

    sayHello("RamSharma")

    val constantVariable = "Once Assigned"
    println(constantVariable)
    // constantVariable = "assigned again"  // error statement, val can not be re-assigned

    // read-only list
    val aRoList = listOf("Java")
    println(aRoList)

    displaySeparator()
    println()
    displaySeparator('#', 11)
    println()

    // overloading of methods not required as in Java, as the default arg works
    var s = sum(1,2,3)
    println(s)
    s = sum(a=1,b=2)
    println(s)
    s = sum(a=1)
    println(s)
    s = sum()
    println(s)
}

fun sum(a: Int = 0, b: Int = 0, c: Int = 0): Int{
    return a+b+c
}


fun displaySeparator(charc: Char='*', size: Int=10){
    repeat(size){
        print(charc)
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
} 

fun max(a: Int, b: Int, c: Int): Int {
    return max(a, max(b, c))
}

fun sayHello(a: String) {
    println("Hello $a")
}
