package hello

class AddNumber {
    fun add(a: Int, b: Int): Int {
        var c: Int = a + b
        return c
    }
}

fun main(args: Array<String>) {
    var a = AddNumber()
    var c = a.add(5, 4)
    print(c)
}