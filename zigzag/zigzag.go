func zigzag(a []int) int {
    if len(a) <= 0 {
    	return 0
    }

    // +1 -> go up, -1 -> go down, 0 -> undefied
    var direction int   
    tmpLen := 1
    maxLen := 1

    j := 1
    for j < len(a) {
        if direction == 0 {
            if a[j-1] < a[j] {   // 4,5
                tmpLen++
                direction = -1
            } else if a[j-1] > a[j] {    // 5,4
                tmpLen++
                direction = 1
            }

            j++
        } else {    // 1/-1
            if direction == 1 {
                if a[j-1] < a[j] {
                    direction = -1
                    tmpLen++
                    j++
                } else {
                    tmpLen = 1
                    direction = 0
                }
            } else {    // -1
                if a[j-1] > a[j] {
                    direction = 1
                    tmpLen++
		    j++
                } else {
                    tmpLen = 1
                    direction = 0
                }
            }
        }

        if tmpLen > maxLen {
            maxLen = tmpLen
        }
    }

    return maxLen
}
