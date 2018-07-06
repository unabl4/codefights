# https://codefights.com/challenge/Kk33RmP8zx8TskgpW

var N int = 1000
var m map[int]int = computeTable()  // pre-compute

func computeTable() map[int]int {
    var size, prefixSum int // prefix sum
    m := make(map[int]int)  // m - mapping
    h := make([]int, N) // h - row vector (local variable)
    
    for j := 0; j < N; j++ {
        prefixSum = 0 // reset
        for i := 0; i < N; i++ {
            size = (i+1)*(j+1)
            prefixSum += i+j+2
            h[i] += prefixSum
            
            // set or update
            // m[size] = max(m[size],h[i]) 
            m[h[i]] = max(size, m[h[i]])
        }
    }
    
    return m
}

// ---

func danceStripes(s int) int {    
    if numOfDancers, ok := m[s]; ok {
        return numOfDancers
    } else {
        return -1
    }
}

func max(a,b int) int {
    if a > b {
        return a
    }
    
    return b
}

