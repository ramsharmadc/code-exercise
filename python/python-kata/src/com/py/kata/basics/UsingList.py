def list_fn(lst):
    if lst:
        print 'Working on list => ' + str(lst)
        for e in lst:
            print e


def start():
    l = [5, 2, 3, 7, 10, 12, 1]
    list_fn(l)

    l2 = ['this', 'is', 'a', 'string', 'list', 'but', 2]
    list_fn(l2)

    nums = [2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]
    strs = ['cheese', 'burger', 'sandwich', 'coffee', 'tea']
    empty = []
    nested_list = [1, 2, [3, 4]]

    print nums, strs, empty
    print "nested list => " + str(nested_list)


start()
