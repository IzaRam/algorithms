""" Implements method sort  """
def sort(nums):
    """ recives an number array and returns the sorted array """
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            if nums[i] > nums[j]:
                temp = nums[j]
                nums[j] = nums[i]
                nums[i] = temp

    return nums


if (__name__) == "__main__":
    print(sort([4,2,8,23,1,3,0,10,5,7,43,6,8,23,0,3,1,2,1,0]))  #[0,1,8,23,4,3,2,10,5,7,43,6,8,23]
