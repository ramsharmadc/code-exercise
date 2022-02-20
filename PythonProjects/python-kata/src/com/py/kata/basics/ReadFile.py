def read_some_file():
    book = open("/home/ramsharma/workspace/sourcecode/python/python-kata/src/com/py/kata/basics/ReadFile.py", 'r')
    line1 = next(book)
    print(line1)

    # print(line1[0])
    # print(line1[len(line1)-2])

    line2 = next(book)
    print(line2)
    print("Finished")
    print("Book Name -- " + str(book))

    # Reading whole file
    lines = list(book)
    print(lines)

    # resetting the offset of book, to read from start again
    book.seek(0)

    # iterating over book, line by line
    for line in book:
        print(line)

    # resetting the offset of book, to read from start again
    book.seek(0)

    # characters in file
    number_of_lines = 0
    for line in book:
        number_of_lines += 1

    print("Number of lines in file :: " + str(number_of_lines))

    # resetting the offset of book, to read from start again
    book.seek(0)

    # characters in file
    number_of_chars = 0
    for line in book:
        number_of_chars += len(line)

    print("Number of characters in file :: " + str(number_of_chars))

    book.close()


read_some_file()
