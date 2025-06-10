import random

# Generate List
list = []
for i in range(25):
    list.append(random.randint(1,10))

list2 = list.copy()

print("Unsorted List")
print(list)

# Easy Way
even = [x for x in list if x % 2 == 0]
odd = [x for x in list if x % 2 == 1]

sorted = even + odd
print("Easy Implementation")
print(sorted)

# Two Pointer way

left = 0
right = len(list2) - 1

while (left < right):
    even = list2[left] % 2 == 0
    odd = list2[right] % 2 == 1

    if (not even and not right and odd ):
        


