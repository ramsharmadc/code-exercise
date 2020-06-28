def index_of(word, letter):
    index = 0;

    while (index < len(word)):
        if (word[index] == letter):
            return index

        index = index + 1

    return -1


def last_index_of(word, letter):
    index = len(word) - 1

    while (index > -1):
        if (word[index] == letter):
            return index
        index = index - 1

    return index


def start():
    letter = 'l'
    i = index_of("hello", letter)
    print ('first index of ' + str(letter) + ' = ' + i.__str__())

    i = last_index_of("hello", letter)
    print ('last index of ' + str(letter) + ' = ' + i.__str__())


start()
