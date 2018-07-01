# https://codefights.com/challenge/NWhS2LXhvHZ7CJSK7

import (
    "math"
    "sort"
)

// O(1) check
func isPerfectSquare(n int) bool {
    sqrt := math.Sqrt(float64(n))
    return math.Mod(sqrt,1) == 0 // no decimal part
}

func adjacentSquare(a []int) []int {    
    sort.Ints(a)    // increasing order
    
    // step 1: construct the adjacency graph
    n := len(a)
    G := make([][]int, n)
    for i := 0; i < n; i++ {
        if G[i] == nil {
            G[i] = make([]int, n)
        }
        for j := i+1; j < n; j++ {
            v := a[i]+a[j]
            if isPerfectSquare(v) {
                G[i][j] = 1
                // symmetric path
                if G[j] == nil {
                    G[j] = make([]int, n)
                }
                G[j][i] = 1
            }
        }
    }
    
    // end of step 1
    
    // step 2: Hamilton path exploration
    v := make([]int,n)  // 'n' vector
    path, isPathFound := hamiltonianPath(G,n,v,0)
    
    if isPathFound {
        for idx, node := range path {
            path[idx] = a[node] // update
        }    
    
        return path
    }
    
    return []int{}
}

// DFS
// G - graph, n - graph dimensionality, v - vector, d - depth
func hamiltonianPath(G [][]int, n int, v []int, d int) ([]int, bool) {
    // end
    if d >= n {
        return v,true
    }
    
    // iterate over vertices (nodes)
    VER_LOOP:
        for i := 0; i < n; i++ {
            // check duplicates
            // TODO: use set (hashmap)
            for j := 0; j < d; j++ {
                if v[j] == i {
                    // already taken -> go to the next vertex (node)
                    continue VER_LOOP
                }
            }

            // check if the path exists
            // with exception of the very first node            
            if d <= 0 || G[v[d-1]][i] == 1 {
                v[d] = i  // 'fix' the vertix 
                path, isPathFound := hamiltonianPath(G,n,v,d+1)

                // successful backtrack
                if isPathFound {
                    return path,isPathFound
                }
            }
        }
    
    // path not found
    return []int{},false
}

