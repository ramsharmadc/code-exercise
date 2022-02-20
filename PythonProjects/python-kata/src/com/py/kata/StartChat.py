def start_chat():
    mem = dict()

    print("Start chatting...")
    while (True):
        X, Y = "X", "Y"
        chat_x = input("(X) ")
        chat_y = input("(Y) ")

        if chat_x == '':
            break
        if chat_y == '':
            break

        mem[X] = chat_x
        mem[Y] = chat_y

    # print(chat_x)
    #         print(chat_y)
    print(mem)


start_chat()
