# https://app.codesignal.com/challenge/YW5xo93RhwKjfhXYR

import "math"

type f = float64
type V = []int  // vector of numbers

func recursivePermutations2(k int, i int) int {
    // base case
    if k == 1 {
        return 1
    }
    
    // ---
    
    if i % 2 == 0 {
        // -> reflection
        return int(math.Pow(2,f(k-1)))+1-recursivePermutations2(k-1, i/2)
    } else {
        // -> copy
        return recursivePermutations2(k-1,i/2)
    }
}

