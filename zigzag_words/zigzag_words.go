# https://app.codesignal.com/challenge/tu9KcxX573X9qFxfN

import "strings"

// I am too lazy today to do smart/fancy index math, etc
// Doing something lazy/bruteforce-ish instead
func zigzagWords(s string, l int) string {
    if l <= 1 {
        return s
    }
    
    n := len(s) // input string len
    c := 0  // bucket index
    i := 1  // direction increment (-1,+1)
    t := 0  // total char counter
    v := make([][]string, l)    // 'l' lines
    
    for {
        // EOS pre-condition
        if t == n {
            break
        }
        
        // ignore spaces
        if string(s[t]) == " " {
            t += 1  // next
            continue 
        }
        
        // ---
        
        // change direction
        if i == -1 && c == 0 {
            i = 1   
        } else if i == 1 && c == (l-1) {
            i = -1
        }
        
        // ---
        
        if v[c] == nil {
            v[c] = make([]string,0)
        }
        
        // but the char in correct 'bucket'
        v[c] = append(v[c], string(s[t]))
        
        // post-updates
        t += 1
        c += i
        
    }
    
    // compose the end string
    var strBuilder strings.Builder
    for i := l-1; i >= 0; i-- {
        str := strings.Join(v[i], "")
        strBuilder.WriteString(str)
    }
    
    return strBuilder.String()
}
