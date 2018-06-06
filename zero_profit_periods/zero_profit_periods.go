# https://codefights.com/challenge/EExivsGzRjHjcjA8y

func zeroProfitPeriods(transactions []int) int {
    // 1) construct prefix sums
    n := len(transactions)
    prefix := 0
    prefixSums := make([]int, n+1)
    // prefixSums[0] = 0 (augmented)
    for i := 1; i <= n; i++ {
        prefix += transactions[i-1]
        prefixSums[i] += prefix
    }
    
    // end of 1)
    // ---
    // 2) construct sum -> indicies hashmap
    h := make(map[int][]int) // prefixSum -> array of indices
    
    for idx, sum := range prefixSums {
        h[sum] = append(h[sum],idx)
    }
    
    // end of 2)
    // 3) "collect" (count) periods
    periodsCount := 0
    minStartIndex := 0 // min possible index
    for idx, sum := range prefixSums {
        if val, ok := h[sum]; ok {
            // list of indices found, check if it appeared before (strictly less)
            
            for _, startIdx := range val {
                if startIdx < idx && startIdx >= minStartIndex {
                    minStartIndex = idx // cannot go back further than this index
                    periodsCount++  // increment
                    break   // first occurrence is enough
                }
            }
        }
    }
        
    return periodsCount;
}
