# using string functions


def string_functions(s):
    print str(s).upper()
    print str(s).lower()

    l = 'T'
    print "Found '" + l + "' at " + str(str(s).find(l))

    l = "yth"
    s1 = str(s).lower()
    print "Found '" + l + "' in string '" + s1 + "' at " + str(s1.find(l))


def use_in():
    print "## Use if in() method ##"
    s = "apples"
    print 'pp' in s

    # for each char in string, check in other string
    for l in s:
        if l in 'oranges':
            print l


def get_reverse(s, l):
    if l < 0:
        return "";
    return s[l] + get_reverse(s, l - 1)


def is_reverse(s1, s2):
    if len(s1) != len(s2):
        return False
    i = 0
    j = len(s1) - 1

    while j > 0:
        print i, j
        if s1[i] != s2[j]:
            return False
        i = i + 1
        j = j - 1

    return True


def main():
    """
     s = "pyTHon"
     print "Using String functions on = " + str(s)
     string_functions(s)

     s = 23
     print "Using String functions on = " + str(s)
     string_functions(s)

     s = 'Python is python'
     print "Using String functions on = " + str(s)
     string_functions(s)

     print s.find('yth', 2)  # finds starting from 2 index (inclusive)

     use_in()

     word = 'banana'
     print "word = 'banana'"
     print word == 'banana'

     b = "apples" > "bananas"
     print b
     """

    s1 = "working"
    s2 = "gnikrow"
    p = is_reverse(s1, s2)
    print "is_reverse(s1, s2) = " + str(p)

    s3 = get_reverse(s2, len(s2) - 1)
    print "Reverse of " + s2 + " is " + s3

    print "s3.index('wo') = " + str(s3.index('rk'))

    s = 'banana'
    print s[0:5:2]  # every 2nd char from o(inclusive) till length 5

    s = "eworjeirihduefhrefuerheuusddsuidfuewfduewuifd"
    s1 = s[::-1]
    print "Reverse of " + s + " is = " + s1

    s = "123456"
    print s[len(s)-4:]
    print s[len(s)-5:]
    print s[1:5]


main()
