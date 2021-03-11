def total(nums):
    local_sum = 0
    for i in nums:
        local_sum += i

    print(local_sum)

    # tuples
    (a, b) = (12, 25)
    print(a + b)

    return local_sum


sum_total = total([45, 67, 12, 23, 34, 78, 97, -356])
print(sum_total)
