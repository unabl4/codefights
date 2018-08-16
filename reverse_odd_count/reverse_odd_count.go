# https://app.codesignal.com/challenge/NZLcmPoRjWAMfCbx2

type s = string
func reverseOddCount(str s) s {
    n := len(str)
    // character frequencies
    f := make(map[byte]int)
    for i:=0; i < n; i++ {
        f[str[i]]++
    }
    
    out := make([]byte, n)  // output string
    
    low := 0
    high := n-1
    
    for low <= high {       
        // ignore chars occuring even times on the left side
        for low <= high && f[str[low]] % 2 == 0 {
            out[low] = str[low]
            low++
        }
        
        // ignore chars occuring even times on the right side
        for high >= 0 && f[str[high]] % 2 == 0 {
            out[high] = str[high]
            high--
        }
        
        // extra protection
        if low > high {
            break
        }
        
        // swap
        out[low]  = str[high]
        out[high] = str[low]

        // main
        low++
        high--
    }
    
    return s(out)
}
