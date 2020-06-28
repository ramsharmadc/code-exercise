def has_no_e(word):
    # for c in word:
    #     if c == 'e':
    #         return False
    # return True

    i = 0
    while i < len(word):
        if word[i] == 'e':
            return False
        i = i + 1

    return True


def start():
    s = "Has No word with 'e'"
    print(s)
    has_no_e(s)


start()
