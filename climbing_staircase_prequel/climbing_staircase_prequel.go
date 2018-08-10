# https://app.codesignal.com/challenge/7NiCH9wH8Fj5Ncb2e

type rec [2]int
var mem map[rec]int = make(map[rec]int)
func climbingStaircasePrequel(n int, k int) int {
    key := rec{n,k}
    if val, ok := mem[key]; ok {
        return val 
    }
    
    if n == 0 {
        return 1
    }
    
    // not possible, not needed
    if n < 0 {
        return 0
    }
    
    // ---
    
    var sum int
    for step:=1; step <= k; step++ {    // k <= n
        sum += climbingStaircasePrequel(n-step, k)            
    }
    
    mem[key] = sum  // mem
    return sum
}

