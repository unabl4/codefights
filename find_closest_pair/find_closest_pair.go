# https://codefights.com/challenge/4Q22wFQPwR7zq2FS4

func findClosestPair(numbers []int, sum int) int {
    h := make(map[int][]int)
    
    for idx, i := range numbers {
        h[i] = append(h[i],idx)
    }
    
    isPairFound := false
    closestPairDiff := len(numbers)-1 // max diff
    var closestPairDiffTmp int
    
    for startIdx, i := range numbers {
        res := sum - i
        if val, ok := h[res]; ok {
            // check indicies
            for _, endIdx := range val {   // check end indices
                if startIdx == endIdx {
                    continue    // indicies cannot be the same
                }
                
                isPairFound = true  // pair found
                
                closestPairDiffTmp = abs(startIdx-endIdx)   // abs diff
                if closestPairDiffTmp < closestPairDiff {
                    closestPairDiff = closestPairDiffTmp    // update
                }
            }
        }
    }
    
    if isPairFound {
        return closestPairDiff
    } else {
        // not found
        return -1
    }
}

func abs(x int) int {
    if x < 0 {
        return -x
    } else {
        return x
    }
}
