# https://app.codesignal.com/challenge/ZnZu5e2uRSAHiT2q6

import "strings"
import "regexp"

var re = regexp.MustCompile("[a-zA-Z0-9]")

// 'strings.Title' does not work the way it should
// example: "don't"
func capitalizeString(str string) string {
    a := str[:1]
    b := str[1:]
    
    return strings.ToUpper(a) + strings.ToLower(b)
}

func isEndOfSentence(word string) bool {
    lastChar := string(word[len(word)-1])
    return lastChar == "." || lastChar == "?" || lastChar == "!"
}

// ---

func roadSigns(sign []string) string {
    var n, tmpLen int   // len
    rowNum := len(sign)
    arr := make([][]string, rowNum)
    
    // split strings, determine the 'box' size
    n = rowNum
    for idx, line := range sign {
        words := strings.Split(line, " ")
        tmpLen = len(words)
        if tmpLen > n {
            n = tmpLen
        }
        arr[idx] = words        
    }
    
    // ---
    
    capitalize := true  // start capitalized
    var columnIdx int
    var str strings.Builder
    for i:=0; i < n*n; i++ {
        rowIndex := i % rowNum
        
        row := arr[rowIndex]    // row always exists
        if columnIdx < len(row) {
            word := strings.ToLower(row[columnIdx])
            if capitalize {
                word = capitalizeString(word)
                capitalize = false  // reset
            }
            
            if isEndOfSentence(word) {    // period?
                capitalize = true
            } 
            
            if i > 0 && re.MatchString(word[:1]) {
                str.WriteString(" ")
            }
            str.WriteString(word)
        }
        
        // ---
        // post-update
        if rowIndex >= rowNum-1 {  // ==
            columnIdx += 1  // one to the right
        }
    }
    
    return str.String()
}

