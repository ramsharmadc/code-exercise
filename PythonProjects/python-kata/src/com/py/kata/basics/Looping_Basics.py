# defining functions


def lets_while(n):
    print "Running while loop"
    while n <= 10:
        print(n)
        n += 1
    print('Done!')


def lets_for(word):
    print "Running for loop"
    for c in word:
        print c


def getCount(word, letter):
    c = 0
    for ch in word:
        if ch == letter:
            c += 1
    print ("Occurrences of letter '" + letter + "' in word '" + word + "' = " + str(c))


# calling functions
lets_while(1)
lets_for("Hello")
getCount("Hello", "l")
