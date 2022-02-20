def fib_rec(n):
    if n < 2:
        return n;
    return fib_rec(n-1)+fib_rec(n-2)


def fib_itr(n):
    n0 = 0
    n1 = 1
    res = 0
    while n > 0:
        res = n0+n1
        n0 = n1
        n1 = res
        n = n -1

    return res

n = fib_rec(99)
print (n)

n = fib_itr(99)
print (n)