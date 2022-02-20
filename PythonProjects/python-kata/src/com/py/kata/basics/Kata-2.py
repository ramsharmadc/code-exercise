def convert_to_float(str_var):
    print("float converter.. converting " + str_var + " to float")
    float_a = float(str_var)
    return float_a


def take_input():
    print("I/O manager.. taking input..")
    var = input("Enter number:: ")
    return var


def add_some(x, delta):
    print("Adding some.." + str(delta) + " to " + str(x))  # no implicit conversion from float to string
    return x + delta


def kata_run():
    x = take_input()
    f = convert_to_float(x)
    f = add_some(f, 2.5)
    print(f)


kata_run()
