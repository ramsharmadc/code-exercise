def in_out():
    # message = input('Give your input here -> ')
    # print(message)
    #
    # i = int(input("Whats the number?"))
    # print(i)

    text_space = input("n? ")
    print(str(type(text_space)) + " : ")
    print(text_space)
    # print(ord(text_space))
    # print(chr(text_space))
    number = int(text_space)
    print(str(type(number)) + " : ")
    print(number)
    print(number + 1)
    # print(ord(number))
    print(chr(number))

    text = input("Number? ")
    n = int(text)

    if n % 2 == 0:
        print(text + " is even")
    else:
        print(text + " is odd")

    print("Wasn't that fun!!")

    if (n % 2 == 0):
        print(text + " is divisible by 2")


in_out()
