def usage_list():
    primes = [2, 3, 5, 7, 11, 13, 17, 19, 23]
    print(primes)

    typ = type(primes)
    print(typ)
    print(type(typ))

    print(primes[0])
    print(type(primes[0]))

    print(primes[primes.__len__() - 1])
    print(type(primes[primes.__len__() - 1]))

    print(len(primes))

    print(primes[2])
    primes[2] = 34
    print(primes[2])

    print(primes)

    del primes[4]

    print(primes)

    primes.append(98)
    print(primes)

    primes.reverse()
    print(primes)

    primes.sort()
    print(primes)

    alpha_list = ["alpha", "gamma", "beta", "delta"]
    alpha_list.insert(3, "epsilon")
    alpha_list.sort()
    print(alpha_list)
    alpha_list.reverse()

    alpha_2 = sorted(alpha_list)
    print(alpha_list)
    print(alpha_2)

    alpha_list += ["fenuk"]
    print(alpha_list)

    char_list = "HelloWorld".split()
    print(char_list)
    char_list = list("HelloWorld")
    print(char_list)
    # help(primes)

    # check if a content is in the list using keyword 'in'
    if "alpha" in alpha_list and "alpha" in alpha_2:
        print("Alpha list contains \'alpha\'")


def sum_of_list(l):
    n = 0
    for i in l:
        n += i
    print(n)

    n = sum(l)
    print(n)

    i, n = 0, 0
    while i < len(l):
        n += l[i]
        i += 1

    print(n)


def incremental_sum(l):
    total = 0
    total_so_far = []

    for i in l:
        total += i
        total_so_far.append(total)
    print(total_so_far)

    total = 0
    total_so_far = []
    ls = list(range(0, 1000)) # equals to range(1000) i.e. numbers from 0 - 999
    for j in ls:
        total += j
        total_so_far.append(total)
    print(total_so_far)

    for i in range(len(l)):
        print(l[i])


'''Comment/Uncomment calls below to run the functions'''
incremental_sum([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
# sum_of_list([32, 57, 5, 8, 74, 6, 63, 4])
# sum_of_list([])
# usage_list()
