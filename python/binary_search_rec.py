""" Binary Search """
def binary(nums, val):
    """
        takes a sorted array and a value then returns the value if
        this exists in the array, otherwise it returns None
    """

    pointer = len(nums) // 2

    if nums[pointer] == val:
        return nums[pointer]

    if len(nums) <= 1:
        return None

    if nums[pointer] > val:
        nums = nums[:pointer]
    else:
        nums = nums[pointer:]

    return binary(nums, val)


if (__name__) == "__main__":
    print(binary([1, 2, 4, 6, 7, 9, 12, 43, 75, 82], 5))
