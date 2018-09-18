# https://app.codesignal.com/challenge/naqKjgBEjbBFgK779

import "strings"

// map 'order' in go is not guaranteed
var numerals = [...]int{1000,900,500,400,100,90,50,40,10,9,5,4,1}
var mapping = map[int]string {
    1000: "M",
    900: "CM",  // s
    500: "D",
    400: "CD",  // s
    100: "C",
    90: "XC",   // s
    50: "L",
    40: "XL",   // s
    10: "X",
    9: "IX",    // s
    5: "V",
    4: "IV",    // s
    1: "I",  
}

// ---

func rome(n int) string {
    var res string // ""
    for _,k := range numerals {
        v, _ := mapping[k]
        q := n / k
        n %= k
        res += strings.Repeat(v,q)
    }
        
    return res
}

