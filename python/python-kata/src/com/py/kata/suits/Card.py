class Cards(object):
    def __init__(self, suit=0, rank=2):
        if suit == 1 or rank == 12:
            print("Queen of Diamonds")
        self.suit = suit
        self.rank = rank

    def card_play(self):
        print("Suit:" + str(self.suit))
        print("Rank:" + str(self.rank))


def main_method():
    c = Cards(1, 12)
    c.card_play()


main_method()
