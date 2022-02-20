import math


def differntiate(x, n):
    return n * math.pow(x, n - 1)


def start():
    x = 9
    pow = 4
    r = differntiate(9, 4)
    print r


start()
