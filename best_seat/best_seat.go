# https://app.codesignal.com/challenge/fCGr5sdmh4LdYbai4

func seatFriendliness(layout [][]int, row,col int) int {
    h := len(layout)
    w := len(layout[0])
    
    s := 0
    for y:=-1; y <= 1; y++ {
        for x:=-1; x <= 1; x++ {
            r := row+y
            c := col+x
            if r < 0 || c < 0 || r >= h || c >= w || (y == 0 && x == 0) {
                continue
            }
            
            if layout[r][c] != -1 {
                s += layout[r][c]
            }
            
    
        }
    }
    
    return s
}

func bestSeat(classLayout [][]int) []int {
    bestFriendliness := -1
    bestSeat := []int { -1,-1 }
    
    h := len(classLayout)
    w := len(classLayout[0])
    
    for y:=0; y < h; y++ {
        for x:=0; x < w; x++ {
            if classLayout[y][x] != -1 {
                continue
            }
            
            f := seatFriendliness(classLayout,y,x)
            if f > bestFriendliness {
                bestFriendliness = f
                bestSeat = []int { y,x }
            }
        }
    }
    
    return bestSeat
}

