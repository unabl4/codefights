# https://app.codesignal.com/challenge/jhraS47bNA6u9kAqG

func pjCircle(students int, winners int) []int {
    var numOfStudentsToEliminate int = students-winners
    var c, winnerCount int
    v := make([]int, students)  // students vector
    w := make([]int, winners)   // winners vector
    
    var i,idx int
    for i=0; winnerCount < winners; i++ {
        idx = i % students // 'wrap' around (circle)
        
        if v[idx] == 0 {    // alive?
            c++
        }
        
        if c == 2 {
            if numOfStudentsToEliminate > 0 {
                numOfStudentsToEliminate--   // eliminate
            } else {
                w[winnerCount] = idx+1
                winnerCount++
            }
            c = 0   // reset
            v[idx] = 1
        }
    }
    
    return w
}

