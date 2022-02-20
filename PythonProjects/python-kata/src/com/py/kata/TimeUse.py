from sqlite3 import Time, datetime


class TimeUse(object):
    def __init__(self, start, duration):
        self.start = start
        self.duration = duration

    def add_time(self):
        sum = datetime.time
        sum.hour = self.start.hour + self.duration.hour
        sum.minute = self.start.minute + self.duration.minute
        sum.second = self.start.second + self.duration.minute
        print(sum)


def main():
    start = datetime.time
    start.hour = 9
    start.minute = 30
    start.second = 12

    duration = datetime.time
    duration.hour = 3
    duration.mi = 12
    duration.second = 10

    t = TimeUse(start, duration)
    t.add_time()

main()
