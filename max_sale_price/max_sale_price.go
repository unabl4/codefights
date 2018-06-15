# https://codefights.com/challenge/hs9MMh8yXaS3XGe3M

// typical 0/1 knapsack problem

func maxSalePrice(mass int, marketValues []int) int {
    w := make([]int, 0) // weights
    v := make([]int, 0) // values
    n := 0  // number of items
    
    // step 1: collect the 'items'
    // 'weight' = index
    for weight, marketValue := range marketValues {
        if marketValue == 0 {
            continue
        }
        
        n++        
        w = append(w, weight)
        v = append(v, marketValue)
    }
    
    // step 2: construct the dp table
    var j int
    t := make([][]int, n+1) // zero-row included
    for i := range t {
        t[i] = make([]int, mass+1) // zero-column included
        
        if i <= 0 {
            continue
        }
                
        // i > 0
        // ---

        j = 0   // reset
        for j <= mass {
            if w[i-1] > j {
                // the weight of the item is greater than the mass -> cannot take it
                t[i][j] = t[i-1][j]   
            } else {    // j >= w[i]
                a := t[i-1][j]                  // not taking this item
                b := v[i-1]+t[i-1][j-w[i-1]]    // taking the item + max value for the weight left
                t[i][j] = max(a,b)
            }
            
            j++ // increase the mass
        }
    }
    
    return t[n][mass]
}

func max(a,b int) int {
    if a > b {
        return a
    } else {    // <= 
        return b
    }
}
