def strings_are_immutable():
    strr = "Hello World"
    print(strr[0])
    print(strr[0:5])

    # TypeError: 'str' object does not support item assignment
    # strr[0]='W'


strings_are_immutable()
