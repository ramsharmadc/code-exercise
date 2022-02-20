class Point(object):

    def __init__(self, x, y):
        super().__init__()
        self.x = x
        self.y = y

    def __str__(self, *args, **kwargs):
        print("Point - " + str(self.x) + "," + str(self.y))


def main():
    pt = Point(30, 45)
    pt.__str__()


main()
