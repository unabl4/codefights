# https://app.codesignal.com/challenge/S6Ji9uDSocTRhHjks

import "sort"

func arrayTriplets(arr []int) int {
    n := len(arr)
    sort.Ints(arr)
    
    c := 0 // counter
    for i := 0; i < n; i++ {
        for j := i+1; j < n; j++ {
            t := arr[i] + arr[j] // target value
            o := sort.Search(n, func(i int) bool { return arr[i] >= t })  // ~ bisect left
            c += max(o-j-1,0)
        }
    }
    
    // ---
    return c
}

func max(a,b int) int {
    if a > b {
        return a
    }
    
    return b
}

// ---

// Python version with does NOT pass
// from bisect import bisect_left as B

// def arrayTriplets(arr):
//     n = len(arr)
//     s = sorted(arr) # for binary search
    
//     print(s)
    
//     # main loop:
//     c = 0 # counter
//     for i in range(n-2):
//         for j in range(i+1,n-1): # next
//             t = s[i]+s[j] # target value
//             o = B(s,t) # ~log2(N)          
//             c += max(o-j-1,0)
    
//     # ---
//     return c
