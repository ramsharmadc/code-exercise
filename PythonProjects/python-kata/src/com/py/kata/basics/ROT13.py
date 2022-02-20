# coding=utf-8
"""

ROT13 is a weak form of encryption that involves “rotating” each letter in a word
by 13 places. To rotate a letter means to shift it through the alphabet, wrapping around to the
beginning if necessary, so ’A’ shifted by 3 is ’D’ and ’Z’ shifted by 1 is ’A’.
Write a function called rotate_word that takes a string and an integer as parameters, and that
returns a new string that contains the letters from the original string “rotated” by the given amount.
For example, “cheer” rotated by 7 is “jolly” and “melon” rotated by -10 is “cubed”.
You might want to use the built-in functions ord , wh

"""


def encrypt(s, offset):
    # for c in s:
    # o = ord(c)
    # print o
    # print chr(o)

    print "ROT13 encryption started..."
    en = ""
    for c in s:
        s1 = chr(ord(c) + offset)
        # print s1
        en = en + s1

    # print "Encrypted = " + en
    return en


def main():
    s = "cheer"
    e = encrypt(s, 7)
    print "'" + s + "' is ROT12 encrypted to '" + e + "'"

    s = "melon"
    e = encrypt(s, -1)
    print "'" + s + "' is ROT12 encrypted to '" + e + "'"

    s = "RamSharma"
    e = encrypt(s, 7)
    print "'" + s + "' is ROT12 encrypted to '" + e + "'"


main()
