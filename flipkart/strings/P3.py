def swap(lst, i, j):
    tmp = lst[i]
    lst[i] = lst[j]
    lst[j] = tmp

def reverse_list(lst ):
    l = 0
    r = len(lst) - 1
    while l < r:
        swap(lst, l, r)
        l += 1
        r -= 1

def reverseString(s):
    chars = [ x for x in s ]
    reverse_list(chars)
    return "".join(chars)
