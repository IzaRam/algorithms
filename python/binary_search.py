""" Binary Search """
def binary(nums, val):
    """
        takes a sorted array and a value then returns the value if
        this exists in the array, otherwise it returns None
    """
    while len(nums) > 1:
        pointer = len(nums) // 2
        if nums[pointer] == val:
            return nums[pointer]

        if nums[pointer] > val:
            nums = nums[:pointer]
        else:
            nums = nums[pointer:]

    if nums[0] == val:
        return nums[0]

    return None


if (__name__) == "__main__":
    print(binary([1, 2, 4, 6, 7, 9, 12, 43, 75, 82], 7))
