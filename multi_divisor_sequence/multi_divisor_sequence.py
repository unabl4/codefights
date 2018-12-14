# https://app.codesignal.com/challenge/supdEsjKCT7NMLDi2

def multiDivisorSequence(nums):    
    for i in range(1,len(nums)):
        if nums[i-1] % nums[i] > 0 and (i < 2 or nums[i] % nums[i-2] > 0):
            return nums[i]
    
    # all valid
    return -1
