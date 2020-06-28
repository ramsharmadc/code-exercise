def fun():
    try:
        print((2 < 10) < 20)

        n = 9
        print("13 > " + str(n) + " < 23 = " + str(13 > n < 23))

        print(not n > 10)
        print(not (n > 10))

        print(2 + 3 * 6)
        print(2 + (3 * 6))
        print((2 + 3) * 6)

        # 2/0
    except ArithmeticError:
        print("Arithmetic Exception")


fun()


def newFun():
    str_1 = "Hello String"
    print(str_1)
