# https://app.codesignal.com/challenge/fy3iZcCkd54Ef3AjC

type s = string
type w = []int

func charLocation(text string, width int, char string) [][]int {
    n := len(text)
    pos := make([]w, 0) // positions

    for i:=0; i < n; i++ {
        line := i / width   // line number
        startIdx := line * width
        
        if line % 2 == 0 {
            // left-to-right
            if s(text[i]) == char {
                pos = append(pos, w{line,i-startIdx})
            }
        } else {
            // right-to-left (reversed)
            endIndex := min(n-1, startIdx+width)  // important
            currentIndex := endIndex+startIdx-i-1
            
            if s(text[currentIndex]) == char {
                // the 'endIndex' CANNOT be used, since it ignores the 'box' 
                finalIdx := startIdx+width-currentIndex-1
                pos = append(pos, w{line,finalIdx})
            }
        }
    }
    
    return pos
}

func min(a,b int) int {
    if a < b {
        return a
    }
    
    return b
}

