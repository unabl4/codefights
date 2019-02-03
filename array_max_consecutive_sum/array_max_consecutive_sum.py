# https://app.codesignal.com/challenge/4g6CMty5kLMxivyHR

def arrayMaxConsecutiveSum(arr,k):
    ms = s = sum(arr[i] for i in range(k))
    for j in range(1,len(arr)-k+1):
        s = s-arr[j-1]+arr[k+j-1]
        ms = max(ms,s) # update max sum
    
    return ms
