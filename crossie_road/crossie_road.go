# https://app.codesignal.com/challenge/GtKQ6DCwjZTbK62yY

func crossieRoad(lanes [][]int) int {
    // step 1: determine the max period
    // max period = LCM(period1, period2, ..., periodN)
    var maxPeriod int = 1   // cannot be zero, incorrect value otherwise
    for _, lane := range lanes {
        lanePeriod := lane[0]+lane[1]
        maxPeriod = lcm(maxPeriod, lanePeriod)
    }
    
    // step 2: run the loop from 1 to max period
    // and check for a possible gap; -1 otherwise
    TIME_LOOP:
    for t:=0; t <= maxPeriod; t++ {
        for _, lane := range lanes {
            if t < lane[2] {
                continue    // we can pass -> no cars YET
            }
            
            lanePeriod := lane[0]+lane[1]
            lanePeriodIdx := (t-lane[2]) % lanePeriod
                        
            if lanePeriodIdx < lane[0] {
                continue TIME_LOOP
            }
        }
        
        return t+1
    }
        
    // not possible
    return -1
}

// ---

func lcm(x,y int) int {
    return x*y / gcd(x,y)
}

func gcd(x, y int) int {
    for y != 0 {
        x, y = y, x%y
    }
    return x
}
