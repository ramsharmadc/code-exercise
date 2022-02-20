class TupleEx1(object):
    def __init__(self, email_adrs):
        self.email = email_adrs
        self.uname, self.domain = self.email.split("@")
        print("Welcome " + self.uname)
        print("Your domain is " + self.domain)
        # t = divmod(27, 3)
        # print("divmod(27,3) is " + str(t))

    def find_quot_remainder(self, t):
        r = divmod(t[0], t[1])
        print("divmod(" + str(t[0]) + "," + str(t[1]) + ") is " + str(r))

    def min_max(self, t):
        return min(t), max(t)


def main():
    try:
        t = TupleEx1("ram.sharma@gmail.com")
        m = (45, 15)
        t.find_quot_remainder(m)
        tupl = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 12, 14, 15, 16, 17, 18, 19, 20)
        min, max = t.min_max(tupl)
        print(min)
        print(max)
    except:
        print("ERROR")


main()
