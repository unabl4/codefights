# https://codefights.com/challenge/pcHsPcqKBoiQjJyCx

func alternatingKeys(text string) int {
    var charset int
    var duration int
    
    // keyboard mapping
    m := map[string]int {
        "q": 1,
        "w": 1,
        "e": 1,
        "r": 1,
        "t": 1,
        "a": 1,
        "s": 1,
        "d": 1,
        "f": 1,
        "g": 1,
        "z": 1,
        "x": 1,
        "c": 1,
        "v": 1,
        "b": 1,
        // ---
        "y": 2,
        "u": 2,
        "i": 2,
        "o": 2,
        "p": 2,
        "h": 2,
        "j": 2,
        "k": 2,
        "l": 2,
        "n": 2,
        "m": 2,
    }
    
    fmt.Println(len(text))
    
    for i := 0; i < len(text); i++ {
        char := string(text[i]) // byte -> string
        
        // space?
        if char == " " {
            duration += 50
            if charset == 1 {
                charset = 2
            } else if charset == 2 {
                // reset
                charset = 1
            }
            continue
        }
        
        if charset == 0 {
            // the very first char
            duration += 50
        } else {
            // compare charsets
            if m[char] == charset {
                duration += 75
            } else {
                duration += 50
            }
        } 
        
        // update the 'charset'
        charset = m[char]
    }
    
    return duration
}
