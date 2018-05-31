# https://codefights.com/challenge/tbnvdumnQNifQJ8CK

import "strings"

var distanceCache = map[string]map[string]int{}

// save
func Cache(a,b string, d int) {
    if distanceCache[a] == nil {
        distanceCache[a] = make(map[string]int)
    }
    
    distanceCache[a][b] = d
}

// calculates the levenstein distance between the two words
func LevensteinDistance(a, b string) int {
    // check cache (TLE, otherwise)
    c := distanceCache[a]
    if c != nil {        
        if val, ok := distanceCache[a][b]; ok {
            return val
        }
    }
    
    d := make([][]int, len(a)+1)
    for i := range d {
        d[i] = make([]int, len(b)+1)
    }
    for i := range d {
        d[i][0] = i
    }
    for j := range d[0] {
        d[0][j] = j
    }
    for j := 1; j <= len(b); j++ {
        for i := 1; i <= len(a); i++ {
            if a[i-1] == b[j-1] {
                d[i][j] = d[i-1][j-1]
            } else {
                min := d[i-1][j]
                if d[i][j-1] < min {
                    min = d[i][j-1]
                }
                if d[i-1][j-1] < min {
                    min = d[i-1][j-1]
                }
                d[i][j] = min + 1
            }
        }
 
    }
    
    distance := d[len(a)][len(b)]
    Cache(a,b, distance)
    return distance
}

func autocorrect(trainingWords []string, typedWords []string) string {
    correctedWords := make([]string, len(typedWords))
    
    // map
    for idx, x := range typedWords {  // for each of the types words
        minDistance := 1000 // does not matter
        var tmpDistance int
        var minWord string
        
        for _, y := range trainingWords {
            tmpDistance = LevensteinDistance(x,y)
            if tmpDistance < minDistance {
                minDistance = tmpDistance
                minWord = y
            }
        }
        
        correctedWords[idx] = minWord
    }
    
    return strings.Join(correctedWords, " ")
}

