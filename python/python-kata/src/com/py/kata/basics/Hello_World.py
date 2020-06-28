import builtins


def print_me(msg):
    builtins.print('message:: ' + msg)


def working_with_monsters():
    print_me('Monsters are hard to work with but you learn to win')


def check_type():
    print(type('Hello World by typefun'))


def check_strings():
    print("Hello")  # double quotes are fine
    print('Hello')  # single quotes are also fine
    print('Hello there, \nHow\'s world out there')
    print('''I am
    a multileveubutu
    message but
    I am very
    short message
    also''')


def say_hello(to, msg):
    print_me('Hello, ' + to + ". " + msg)
    working_with_monsters()  # if this is defined down after the call, the call fails
    check_type()
    check_strings()


say_hello('World', 'How is it going!!')
check_type()
