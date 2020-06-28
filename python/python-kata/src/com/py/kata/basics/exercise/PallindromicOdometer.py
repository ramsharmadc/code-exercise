# coding=utf-8
'''
I was driving on the highway the other day and I happened to notice my odometer.
Like most odometers, it shows six digits, in whole miles only. So, if my car had 300,000
miles, for example, I’d see 3-0-0-0-0-0.
“Now, what I saw that day was very interesting.
I noticed that the last 4 digits were
palindromic; that is, they read the same forward as backward.
For example, 5-4-4-5 is a
palindrome, so my odometer could have read 3-1-5-4-4-5.
“One mile later, the last 5 numbers were palindromic. For example, it could have read
3-6-5-4-5-6.
One mile after that, the middle 4 out of 6 numbers were palindromic. And
you ready for this?
One mile later, all 6 were palindromic!
“The question is, what was on the odometer when I first looked?
'''


def find_those_6_digits():
    minn = 300000  # that's where it started
    maxx = 999999

    while minn < maxx:
        s = str(minn)
        # print s
        if is_pallindrome(s[len(s) - 4:]):
            minn = minn + 1
            s1 = str(minn)
            # print s1
            if is_pallindrome(s1[len(s) - 5:]):
                minn = minn + 1
                s2 = str(minn)
                # print s2
                if is_pallindrome(s2[1:5]):
                    minn = minn + 1
                    s3 = str(minn)
                    # print s3
                    if is_pallindrome(s3):
                        print (s)
                        return
        minn = minn + 1


def is_pallindrome(nbr):
    s = str(nbr)
    # print s
    r = s[::-1]
    # print r
    return s.__eq__(r)



def start():
    s = "9889"
    # print is_pallindrome(s)
    find_those_6_digits()

def end():
    print ("End")

start()
