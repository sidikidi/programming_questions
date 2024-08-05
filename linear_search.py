"""
python is a weakly typed language,ie data types are not required while coding ,
infact the data types are identified at run time
however it does not mean that python has no data types

"""
"""
Linear search return index of the value
"""


def linear_search1(arr, val):
    index = 0
    for i in arr:
        if i == val:
            return index
        index = index + 1
    return -1


"""
Explaination: 
Loop at line no 14 takes the actual value  that are stored in a list
index is incremented at line 17 after checking the value
What if  the value is increment before checking the value 
it always return 1 index more as in below sample
"""


def linear_search2(arr, val):
    index = -1
    for i in arr:
        index = index + 1
        if i == val:
            return index

    return index


"""
observer the difference
"""
"""
For loop using index values 
"""


def linear_search3(arr, val):
    length = len(arr)
    for i in range(0, length):
        if arr[i] == val:
            return i

    return -1


"""
In range last value is not included
"""
if __name__ == '__main__':
    arr = [8, 1, 9, 6, 5, 4]
    print(linear_search1(arr, 4))
    print(linear_search2(arr, 4))
    print(linear_search3(arr, 4))
