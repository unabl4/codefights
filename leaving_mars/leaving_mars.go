# https://codefights.com/challenge/oTLfSkJAeeDzxNwzw

func leavingMars(gates []int, destinations [][]int) []int {
    // step 1: build the initial matrix
    inf := int(1e9)  // infinity (no path); the value itself does not really matter
    n := len(gates)  // n x n matrix
    m := make([][]int, n)    // 'from'
    
    for i, gate := range gates {    // source
        m[i] = make([]int, n)   // row
        
        for j := 0; j < n; j++ {
            if i == j {
                m[i][j] = 0 // self
            } else if j-i == 1 || i-j == 1 || j == gate {
                // adjacent, neigbour paths OR a portal path
                m[i][j] = 1
            } else {    // no neigbours, no portal
                m[i][j] = inf   // no direct path
            }
        }
    }
    
    // step 2: run the Floyd-Warshall algorithm to find all shortest paths
    for k := 0; k < n; k++ {
        for i := 0; i < n; i++ {
            if i == k {
                continue    // skip recalculation -> not needed
            }
            
            for j := 0; j < n; j++ {
                if i == j || i == k {
                    continue // skip recalculation -> not needed
                }
                
                a := m[i][j]    // original path
                b := m[i][k] + m[k][j]
                m[i][j] = min(a,b)
            }
        }
    }
    
    // step 3: query the distances
    r := make([]int, len(destinations)) // return value vector
    for idx, destQuery := range destinations {
        s := destQuery[0]   // path source
        d := destQuery[1]   // path destination
        
        r[idx] = m[s][d]
    }
    
    return r
}

func min(a,b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}

