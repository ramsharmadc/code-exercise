def sqrt_ex():
    tolerance = 1.0e-15
    lower = 0.0
    upper = 2.0
    uncertainity = upper - lower

    while uncertainity > tolerance:
        middle = (lower + upper) / 2
        if middle ** 2 < 2.0:
            lower = middle
        else:
            upper = middle

        print(lower, "|", upper)
        uncertainity = upper - lower

sqrt_ex()
