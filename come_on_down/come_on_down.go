# https://app.codesignal.com/challenge/W3iEJPAy39CsM2B6g

import "sort"

func comeOnDown(maxPrice int, bids []int) int {
    n := len(bids)
    sort.Ints(bids) // ?
    
    bids = append([]int{0}, bids...)   // min bid
    bids = append(bids, maxPrice)
    
    maxDiff := -1
    minBid := -1
    var inclusionSign int
    for i := n+1; i > 0; i-- {
        if i == n+1 {
            inclusionSign = 0
        } else {
            inclusionSign = -1
        }
        currentBid := bids[i]  // current bid
        // ignore the bids higher than the max price 
        // -> not possible to win anyway
        if currentBid > maxPrice {
            continue
        }
        
        // ---
        // skip impossible values
        for bids[i-1] > maxPrice {
            i--
        }
        
        previousBid := bids[i-1]
        diff := currentBid-previousBid+inclusionSign
        if maxDiff == -1 || diff >= maxDiff {   // update
            maxDiff = diff
            minBid = previousBid+1
        }
    }
    
    // return the lowest bid
    return minBid
}

