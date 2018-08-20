# https://app.codesignal.com/challenge/rb3XgKmHEoxx5uMB8

import "strings"

var m = map[string]int {
    "one": 1,
    "two": 2,
    "three": 3,
    "four": 4,
    "five": 5,
    "six": 6,
    "seven": 7,
    "eight": 8,
    "nine": 9,
    "ten": 10,
    "eleven": 11,
    "twelve": 12,
    "thirteen": 13,
    "fourteen": 14,
    "fifteen": 15,
    "sixteen": 16,
    "seventeen": 17,
    "eighteen": 18,
    "nineteen": 19,
    // ---
    "twenty": 20,
    // ---
    "thirty": 30,
    "forty": 40,
    "fifty": 50,
    "sixty": 60,
    "seventy": 70,
    "eighty": 80,
    "ninety": 90,
    "hundred": 100,
}

// stop word(s)
var units = map[string]int {
    "hundred":  int(1e2),  // 10^2
    "thousand": int(1e3),  // 10^3
    "million":  int(1e6),  // 10^6
    "billion":  int(1e9),  // 10^9
}

// ---

func word2Num(str string) int {
    var num int // = 0
    // step 1: normalize, casing, remove extra spaces, commas, 'and'
    r := strings.NewReplacer(",", "", "-", " ", " and", "")
    fmtStr := strings.ToLower(r.Replace(str)) // formatted string
    // step 2: ...
    tokens := strings.Split(fmtStr, " ")
    
    var tmpNum int
    for _, token := range tokens {
        // reached -> flush the temp
        if mult, ok := units[token]; ok {   // multiplier
            tmpNum *= mult
            if mult >= int(1e3) {   // thousand, million, billion
                num += tmpNum   // add
                tmpNum = 0  // reset
            }
        } else {
            tmpNum += m[token]
        }
    }   // end loop
    
    // residue
    if tmpNum > 0 {
        num += tmpNum
    }
    
    return num
}

// u1 * 10^9 + u2 * 10^6 + u3 * 10^3 + u4 * 10^2 + ... + u5 
// [(9, u10^2, 80, 7), u10^6, (6, u10^2, 50, 4), u10^3, (3, u10^2, 20, 1)]
