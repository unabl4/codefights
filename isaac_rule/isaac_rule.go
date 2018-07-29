# https://app.codesignal.com/challenge/aCvD2B4rqZvziDZuy

func IsaacRule(steps int, number int) int {
    arr := []int { number } // initial state
    h := make(map[int]bool) // to store 'seen' numbers (avoid duplicates)
    
    for i := 0; i < steps; i++ {
        tmp := []int {}
        for _, n := range arr {
            // if the predecessor (n) is odd
            // the 3*n is also odd (odd * odd = odd), 
            // plus odd (+1) -> so the current number MUST be even
            if n % 2 == 0 && (n-1) % 3 == 0 {
                a := (n-1)/3
                
                if _, ok := h[a]; !ok {
                    h[a] = true
                    tmp = append(tmp,a)
                }
            }
            
            // even * even (2) -> even
            // odd * even (2) -> even
            b := 2*n
            if _, ok := h[b]; !ok {
                h[b] = true
                tmp = append(tmp, b)
            }
        }
        
        // update
        arr = tmp
    }
    
    return len(arr)
}
