# https://codefights.com/challenge/3YEFabqW4ypoMMB59

func stonesForCrown(stones []int) int {
    // step 1: construct the freq map
    // stone value => occurrence
    h := make(map[int]int)
    for _, stone := range stones {
        h[stone]++
    }
    
    // ---
    
    // step 2: reverse the map and group freqs
    z := make(map[int][]int)
    for k,v := range h {
        if z[v] == nil {
            // TODO: improve memory allocations (if possible)
            z[v] = make([]int,0)
        }
        z[v] = append(z[v],k)
    }
    
    // ---
    
    // step 3: find the max freqs with at least two stone sizes
    var maxStoneSet int = -1
    for k,v := range z {
        if k > maxStoneSet && len(v) > 1 {
            maxStoneSet = k
        }
    }
    
    if maxStoneSet == -1 {
        return -1
    }
    
    // ---
    
    // step 4: find the largest stone in the stone set
    stoneSet := z[maxStoneSet]
    maxStone := 0   // max stone value within the stone set
    
    for _, stoneValue := range stoneSet {
        if stoneValue > maxStone {
            maxStone = stoneValue
        }
    }
    
    return maxStone
}

