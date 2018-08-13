# https://app.codesignal.com/challenge/zjZbvBrQEpfscdoLk

import "strings"

func min(vals...int) int {
    m := vals[0]
    
    for _,v := range vals {
        if v < m {
            m = v
        }
    }
    
    return m
}

func levensteinDistance(str1, str2 string) int {
    a := len(str1)
    b := len(str2)
    
    t := make([][]int, a+1)
    for i:=0; i<=a; i++ {   //a+1
        t[i] = make([]int, b+1)
    }
    
    // important
    for j := range t[0] {
        t[0][j] = j
    }
    
    for j := range t {
        t[j][0] = j
    }
    
    for i:=1; i<=a; i++ {
        for j:=1; j<=b; j++ {
            if str1[i-1] == str2[j-1] { // important
                t[i][j] = t[i-1][j-1]   // as if this character was not there
            } else {
                t[i][j] = min(t[i-1][j], t[i][j-1], t[i-1][j-1])+1
            }
        }
    }
    
    // fmt.Println(t)
    return t[a][b]
}

// ===

func oneWordStory(words []string, sentences []string) string {    
    var lastWord, maxDistanceWord, finalSentence string
    var sentenceWords []string
    var maxDistance, currentDistance int
    
    // form the word inventory
    wordsInventory := make(map[string]int)
    for _, word := range words {
        wordsInventory[word]++
    }
        
    for sentenceIdx, sentence := range sentences {
        maxDistance = -1    // reset
        sentenceWords = strings.Split(sentence, " ")    // split (space)
        lastWord = sentenceWords[len(sentenceWords)-1]
        
        // fmt.Println(selectedWords)
        for _, word := range words {
            if wordsInventory[word] <= 0 {
                continue    // ignore the word that is already in use
            }
            
            currentDistance = levensteinDistance(lastWord, word)
            
            if maxDistance == -1 {  // init
                maxDistance = currentDistance
                maxDistanceWord = word
            } else if currentDistance == maxDistance {
                // same distance - check lexicographical order
                if word > maxDistanceWord {
                    maxDistanceWord = word
                }
            } else if currentDistance > maxDistance {    // greater distance
                maxDistance = currentDistance
                maxDistanceWord = word
            }
        }
        
        // mark the word as taken
        wordsInventory[maxDistanceWord]--    // decrement
        finalSentence += sentence + " " + maxDistanceWord
        if sentenceIdx < len(sentences)-1 {
            finalSentence += " "
        }
    }
    
    return finalSentence
}

