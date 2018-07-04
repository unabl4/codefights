# https://codefights.com/challenge/4PLW8uTndBKB7FghP

import "unicode"

var vowels = map[rune]int { 
    'a': 1, 
    'i': 1, 
    'e': 1, 
    'o': 1, 
    'u': 1,
}

func hardSurname(surname string) int {
    var length, maxLength int
    
    for _, c := range surname {
        char := unicode.ToLower(c)
        if _, ok := vowels[char]; ok {
            length = 0  // reset
        } else {
            length++
        }
        
        if length > maxLength {
            maxLength = length
        }
    }
    
    return maxLength
}

